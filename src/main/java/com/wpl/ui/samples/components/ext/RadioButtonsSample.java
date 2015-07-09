package com.wpl.ui.samples.components.ext;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiEditable;
import com.github.kennycyb.uifactory.core.factory.annotations.UiInit;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiScrollable;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;
import com.github.kennycyb.uifactory.ext.button.RadioButtons;

@UiLayout(BorderLayout.class)
@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, windowPosition = WindowPosition.CENTER, height = 400, width = 400,
		title = "Radio Buttons Sample")
public class RadioButtonsSample extends JFrame {

	private static Logger LOGGER = LoggerFactory.getLogger(RadioButtonsSample.class);
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a log area in the center.
	 *
	 *
	 *
	 * UiBorderLayoutConstraint - put it into the center
	 *
	 * UiScrollable - add a scrollbar around the component
	 *
	 * UiEditable(false) - disable editing
	 */
	@UiScrollable
	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	@UiEditable(false)
	JTextArea log;

	/**
	 * Create a RadioButtons, and put it at the bottom
	 */
	@UiBorderLayoutConstraint(BorderLayoutConstraint.SOUTH)
	RadioButtons radioButtons;

	@UiInit
	void uiInit() {

		radioButtons.addRadioButton(new JRadioButton("Male"));
		radioButtons.addRadioButton(new JRadioButton("Female"));
	}

	/**
	 * Callback method when any radio button is clicked.
	 *
	 * @param e
	 */
	void onRadioButtons_actionPerformed(final ActionEvent e) {

		final String message = String.format("actionPerformed: %s", e.getActionCommand());

		log.append(message);
		log.append("\n");

		LOGGER.debug(message);
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SwingFactory.create(RadioButtonsSample.class).setVisible(true);
	}
}
