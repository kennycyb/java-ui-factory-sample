package com.wpl.ui.samples.gpg;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JButtonProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

@UiLayout(FlowLayout.class)
@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, windowPosition = WindowPosition.CENTER, title = "GPG", height = 400, width = 300)
public class GpgConsole extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4416152086085983920L;

	@JButtonProperties(text = "Decrypt")
	JButton decrypt;

	void onDecrypt_actionPerformed(final ActionEvent e) {
		SwingFactory.create(GpgDecrypt.class).setVisible(true);
	}

	public static void main(final String[] args) {
		SwingFactory.create(GpgConsole.class).setVisible(true);
	}
}
