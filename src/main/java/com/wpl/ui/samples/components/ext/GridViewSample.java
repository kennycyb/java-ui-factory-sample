package com.wpl.ui.samples.components.ext;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.components.JFrameProperties;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiWindowPosition;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;
import com.github.kennycyb.uifactory.ext.gridview.GridView;
import com.wpl.ui.samples.model.Person;

@JFrameProperties(frameCloseOperation = FrameCloseOperation.EXIT, height = 600, width = 800, title = "GridViewSample")
@UiWindowPosition(WindowPosition.CENTER)
@UiLayout(BorderLayout.class)
public class GridViewSample extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(GridViewSample.class);

	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	private GridView<Person> gridView;

	@UiBorderLayoutConstraint(BorderLayoutConstraint.EAST)
	private JButton action1;

	void onGridView_init() {
		LOGGER.debug("mainGridView_init");
		assert gridView != null;
	}

	void onAction1_actionPerformed(final ActionEvent e) {
		final Person p = new Person();
		p.setFirstName("Kenny");
		p.setLastName("Chong");
		gridView.addData(p);
	}

	public static void main(final String[] args) {
		SwingFactory.create(GridViewSample.class).setVisible(true);
	}
}
