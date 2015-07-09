package com.github.kennycyb.uifactory.sample.mysql;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, height = 400, width = 400, windowPosition = WindowPosition.CENTER)
public class MySQLConsole extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	class Content extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

	}

	public static void main(final String[] args) {
		SwingFactory.create(MySQLConsole.class).setVisible(true);
	}
}
