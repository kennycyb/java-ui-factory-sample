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
package com.github.kennycyb.uifactory.sample.panel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiInit;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

/**
 *
 * @since 1.0
 */

@UiLayout(BorderLayout.class)
@JFrameProperties(title = "Sample With External Panel", windowPosition = WindowPosition.CENTER, width = 800, height = 600,
		frameCloseOperation = FrameCloseOperation.EXIT)
public class SampleWithExternalPanel extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -4487401985785301759L;

	private static Logger LOGGER = LoggerFactory.getLogger(SampleWithExternalPanel.class);

	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	ExternalPanel external;

	public static void main(final String[] args) {
		SwingFactory.create(SampleWithExternalPanel.class).setVisible(true);
	}

	@UiInit
	void init() {
	}

	void onExternal_customEvent(final CustomEventArgs customEventObject) {
		LOGGER.debug("customEvent {}", customEventObject.getMessage());
		JOptionPane.showMessageDialog(this, "onExternal_customEvent: " + customEventObject.getMessage());
	}

	void onExternal_exitEvent(final CustomEventArgs customEventObject) {
		JOptionPane.showMessageDialog(this, "onExternal_exitEvent: " + customEventObject.getMessage());
		setVisible(false);
		dispose();
	}
}
