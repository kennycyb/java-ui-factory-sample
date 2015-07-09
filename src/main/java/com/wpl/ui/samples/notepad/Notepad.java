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
package com.wpl.ui.samples.notepad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kennycyb.uifactory.core.factory.SwingFactory;
import com.github.kennycyb.uifactory.core.factory.annotations.UiAutoWired;
import com.github.kennycyb.uifactory.core.factory.annotations.UiComponentOf;
import com.github.kennycyb.uifactory.core.factory.annotations.UiFont;
import com.github.kennycyb.uifactory.core.factory.annotations.UiInit;
import com.github.kennycyb.uifactory.core.factory.annotations.UiLayout;
import com.github.kennycyb.uifactory.core.factory.annotations.UiResource;
import com.github.kennycyb.uifactory.core.factory.annotations.UiScrollable;
import com.github.kennycyb.uifactory.core.factory.annotations.UiSize;
import com.github.kennycyb.uifactory.core.factory.annotations.UiText;
import com.github.kennycyb.uifactory.core.factory.annotations.constraints.UiBorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiFrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiFrameMenu;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiFrameResizable;
import com.github.kennycyb.uifactory.core.factory.annotations.frame.UiWindowPosition;
import com.github.kennycyb.uifactory.core.factory.enums.BorderLayoutConstraint;
import com.github.kennycyb.uifactory.core.factory.enums.FontStyle;
import com.github.kennycyb.uifactory.core.factory.enums.FrameCloseOperation;
import com.github.kennycyb.uifactory.core.factory.enums.ScrollBarPolicy;
import com.github.kennycyb.uifactory.core.factory.enums.WindowPosition;

/**
 * Sample of Notepad Application.
 */
@UiWindowPosition(WindowPosition.CENTER)
@UiText("Notepad")
@UiSize(height = 600, width = 800)
@UiLayout(BorderLayout.class)
@UiFrameCloseOperation(FrameCloseOperation.EXIT)
@UiFrameResizable
@UiAutoWired
@UiFont(name = "Arial", style = FontStyle.BOLD, size = 12)
public class Notepad extends JFrame {

	private static Logger LOGGER = LoggerFactory.getLogger(Notepad.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@UiBorderLayoutConstraint(BorderLayoutConstraint.CENTER)
	@UiScrollable(horizontal = ScrollBarPolicy.ALWAYS, vertical = ScrollBarPolicy.ALWAYS)
	@UiFont(name = "Arial", style = FontStyle.BOLD, size = 12)
	JTextArea content;

	@UiFrameMenu
	@UiResource("Notepad-Menu.xml")
	@UiFont(name = "Arial", style = FontStyle.BOLD, size = 12)
	JMenuBar menuBar;

	@UiComponentOf("menuBar")
	private JMenuItem undo;

	@UiComponentOf("menuBar")
	private JMenuItem cut;

	@UiInit
	void init() {
		undo.setEnabled(false);
		cut.setEnabled(false);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.ALT_DOWN_MASK), "doNothing");

		getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.ALT_DOWN_MASK), "doNothing");

		getRootPane().getActionMap().put("doNothing", new AbstractAction("doNothing") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("doNothing");
			}
		});

		content.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.ALT_DOWN_MASK), "doNothing");

		LOGGER.debug("Notepad.init");
	}

	/**
	 * Invoked when the caret within composed text has changed.
	 *
	 * @param event
	 */
	void onContext_caretPositionChanged(final InputMethodEvent event) {
		LOGGER.debug("onContext_caretPositionChanged");
	}

	void onContext_inputMethodTextChanged(final InputMethodEvent event) {
		LOGGER.debug("onContext_caretPositionChanged");
	}

	void onThis_windowClosing(final WindowEvent e) {
		LOGGER.debug("onThis_windowClosing: new state={}", e.getNewState());
	}

	void onThis_windowActivated(final WindowEvent e) {
		LOGGER.debug("onNotepad_windowActivated");
	}

	void onThis_windowGainedFocus(final WindowEvent e) {
		LOGGER.debug("onNotepad_windowGainedFocus");
	}

	void onThis_windowLostFocus(final WindowEvent e) {
		LOGGER.debug("onNotepad_windowLostFocus");
	}

	// TODO:
	void onMenuBar_undo_itemStateChanged(final ItemEvent e) {

	}

	void onMenuBar_itemStateChanged(final ItemEvent e) {
		LOGGER.debug("itemStateChanged: {} ", e.getItem());
	}

	@SuppressWarnings("unused")
	private void onMenuBar_actionPerformed(final ActionEvent e) {

		final String actionCommand = e.getActionCommand();

		if (actionCommand == null) {
			LOGGER.debug("menu-clicked=null");
			return;
		}

		LOGGER.debug("menu-clicked={}", actionCommand);

		if (actionCommand.equals("file.new")) {
			content.setText("");
			return;
		}

		if (actionCommand.equals("file.exit")) {
			System.exit(0);
		}

		if (actionCommand.equals("edit.datetime")) {
			content.append(DateFormat.getDateTimeInstance().format(new Date()));
		}
	}

	public static void main(final String[] args) {
		SwingFactory.create(Notepad.class).setVisible(true);
	}
}
