package com.wpl.ui.samples.components.swing;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JRadioButtonProperties;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;
import com.github.kennycyb.uifactory.core.layout.managers.VerticalFlowLayout;

@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, title = "JRadioButtonSample", windowPosition = WindowPosition.CENTER)
@UiLayout(VerticalFlowLayout.class)
public class JRadioButtonSample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@JRadioButtonProperties(text = "Male", groupId = "sex", selected = true)
	JRadioButton male;

	@JRadioButtonProperties(text = "Female", groupId = "sex")
	JRadioButton female;

	public static void main(final String[] args) {
		SwingFactory.create(JRadioButtonSample.class).setVisible(true);
	}
}
