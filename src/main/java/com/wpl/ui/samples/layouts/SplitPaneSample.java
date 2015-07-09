package com.wpl.ui.samples.layouts;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiScrollable;
import com.github.kennycyb.uifactory.core.factory.annotations.UiSize;
import com.github.kennycyb.uifactory.core.factory.annotations.UiText;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JSplitPaneProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiFrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiFrameResizable;
import com.github.kennycyb.uifactory.core.factory.annotations.layouts.SplitPaneContent;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.ScrollBarPolicy;
import com.github.kennycyb.uifactory.core.factory.enums.SplitPaneOrientation;
import com.github.kennycyb.uifactory.core.factory.enums.SplitPanePosition;

@UiText("JSplitPane Sample")
@UiSize(height = 600, width = 800)
@UiLayout(BorderLayout.class)
@UiFrameCloseOperation(FrameCloseOperation.EXIT)
@UiFrameResizable
public class SplitPaneSample extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@JSplitPaneProperties(orientation = SplitPaneOrientation.HORIZONTAL)
	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	JSplitPane splitPane;

	@SplitPaneContent(splitPaneName = "splitPane", position = SplitPanePosition.LEFT)
	JTree left;

	@SplitPaneContent(splitPaneName = "splitPane", position = SplitPanePosition.RIGHT)
	@UiScrollable(horizontal = ScrollBarPolicy.ALWAYS, vertical = ScrollBarPolicy.ALWAYS)
	JTextArea right;

	public static void main(final String[] args) {
		SwingFactory.create(SplitPaneSample.class).setVisible(true);
	}
}
