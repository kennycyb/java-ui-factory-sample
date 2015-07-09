package com.wpl.ui.samples.components.juf;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.components.ILabel;
import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiInit;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiSpringGridConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, title = "ULabelSample", windowPosition = WindowPosition.CENTER)
@UiLayout(SpringLayout.class)
@UiSpringGridConstraint(cols = 3)
public class ULabelSample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(ULabelSample.class);

	private ILabel myLabel;

	@UiInit
	void init() {
		LOGGER.debug("init OK");
	}

	public static void main(final String[] args) {
		SwingFactory.create(ULabelSample.class).setVisible(true);
	}
}
