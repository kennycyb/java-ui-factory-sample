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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiColumns;
import com.github.kennycyb.uifactory.core.factory.annotations.UiEnabled;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiText;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JSliderProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiSpringGridConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.Orientation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

/**
 *
 * @since 1.0
 */
@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, title = "JSliderSample", windowPosition = WindowPosition.CENTER)
@UiLayout(SpringLayout.class)
@UiSpringGridConstraint(cols = 3)
public class JSliderSample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(JSliderSample.class);

	@UiText("Horizontal Slider")
	JLabel label1;

	@JSliderProperties(minimum = 0, maximum = 100, value = 0)
	JSlider horizontal;

	@UiText("0")
	@UiEnabled(false)
	@UiColumns(5)
	JTextField horizontalValue;

	@UiText("Vertical Slider")
	JLabel label2;

	@JSliderProperties(minimum = 0, maximum = 100, value = 0, orientation = Orientation.VERTICAL)
	JSlider vertical;

	@UiText("0")
	@UiColumns(5)
	@UiEnabled(false)
	JTextField verticalValue;

	void onHorizontal_stateChanged(final ChangeEvent e) {
		horizontalValue.setText(String.valueOf(horizontal.getValue()));
	}

	void onVertical_stateChanged(final ChangeEvent e) {
		verticalValue.setText(String.valueOf(vertical.getValue()));
	}

	public static void main(final String[] args) {
		SwingFactory.create(JSliderSample.class).setVisible(true);
	}
}
