package com.github.kennycyb.uifactory.sample.layouts;

import javax.swing.JTextField;

import com.github.kennycyb.uifactory.core.factory.annotations.layouts.View;

@View(title = "AutoLayout sample", members = "|Hello|{input}"

)
public class AutoLayout {

	JTextField input;
}
