/*
 * Copyright 2010 Kenny Chong (wongpeiling.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kennycyb.uifactory.sample.components.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiText;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JProgressBarProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiSpringGridConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.Orientation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

/**
 *
 * @since 1.0
 */
@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, title = "JProgressBarSample", windowPosition = WindowPosition.CENTER)
@UiLayout(BorderLayout.class)
public class JProgressBarSample extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(JProgressBarSample.class);

	@UiLayout(SpringLayout.class)
	@UiSpringGridConstraint(cols = 2)
	class CenterPanel extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@UiText("Horizontal")
		JLabel label1;

		@JProgressBarProperties(minimum = 0, maximum = 100, orientation = Orientation.HORIZONTAL)
		JProgressBar horizontal;

		@UiText("Vertical")
		JLabel label2;

		@JProgressBarProperties(minimum = 0, maximum = 100, orientation = Orientation.VERTICAL)
		JProgressBar vertical;
	}

	@UiLayout(FlowLayout.class)
	class ButtonPanel extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		@UiText("Start")
		JButton start;
	}

	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	CenterPanel center;

	@UiBorderLayoutConstraint(BorderLayoutConstraint.SOUTH)
	ButtonPanel south;

	void onStart_actionPerformed(final ActionEvent e) {
		new Thread(() -> {

			final JButton sender = (JButton)e.getSource();
			sender.setEnabled(false);

			for (int i = 0; i <= 100; i++) {

				center.vertical.setValue(i);
				center.horizontal.setValue(i);

				LOGGER.debug("setValue={}", i);

				try {
					Thread.sleep(100);
				} catch (final InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			sender.setEnabled(true);
		}).start();
	}

	public static void main(final String[] args) {
		SwingFactory.create(JProgressBarSample.class).setVisible(true);
	}
}
