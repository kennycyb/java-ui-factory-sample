package com.github.kennycyb.uifactory.sample.gpg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiScrollable;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JButtonProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JLabelProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JTextAreaProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JTextFieldProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

@JFrameProperties(frameCloseOperation = FrameCloseOperation.DISPOSE, title = "Decrypt", windowPosition = WindowPosition.CENTER, height = 400, width = 400)
@UiLayout(BorderLayout.class)
public class GpgDecrypt extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 3789607028519367715L;

	@UiLayout(SpringLayout.class)
	private class ContentPanel extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@JLabelProperties(text = "Input")
		JLabel inputLabel;

		@JTextFieldProperties()
		JTextField inputFile;

		@JLabelProperties(text = "Output")
		JLabel ouputLabel;

		@JTextFieldProperties()
		JTextField outputFile;

		@JLabelProperties(text = "Password")
		JLabel passwordLabel;

		JPasswordField password;

		@JLabelProperties(text = "Console")
		JLabel consoleLabel;

		@UiScrollable
		@JTextAreaProperties(rows = 10)
		JTextArea console;
	}

	@UiLayout(FlowLayout.class)
	private class CommandPanel extends JPanel {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		@JButtonProperties(text = "Decrypt")
		JButton decrypt;
	}

	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	ContentPanel content;

	@UiBorderLayoutConstraint(BorderLayoutConstraint.SOUTH)
	CommandPanel command;

	void onDecrypt_actionPerformed(final ActionEvent e) {
		final StringBuilder sb = new StringBuilder("gpg");

		sb.append(" --output ").append(content.outputFile.getText());
		sb.append(" --decrypt ").append(content.inputFile.getText());

		try {
			final Process process = Runtime.getRuntime().exec(sb.toString());

			new Thread() {
				@Override
				public void run() {
					final InputStream in = process.getInputStream();
					while (true) {
						try {
							final int r = in.read();
							content.console.append(String.valueOf(r));
							this.wait(1);
						} catch (final IOException e) {
							e.printStackTrace();
							break;
						} catch (final InterruptedException e) {
						}
					}
				}
			}.start();

			final char[] password = content.password.getPassword();
			final byte[] pass = new byte[password.length];
			for (int i = 0; i < password.length; i++) {
				pass[i] = (byte)password[i];
			}
			process.getOutputStream().write(pass);
			process.waitFor();
		} catch (final IOException e1) {
			e1.printStackTrace();
		} catch (final InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
