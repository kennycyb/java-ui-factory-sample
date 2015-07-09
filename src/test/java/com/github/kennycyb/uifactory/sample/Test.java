package com.github.kennycyb.uifactory.sample;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.github.kennycyb.uifactory.ext.gridview.GridView;
import com.github.kennycyb.uifactory.sample.model.Person;

public class Test {

	private GridView<Person> gridview;

	@org.junit.Test
	public void genericTest() throws SecurityException, NoSuchFieldException, ClassNotFoundException {

		final Field field = this.getClass().getDeclaredField("gridview");

		final ParameterizedType type = (ParameterizedType)field.getGenericType();

		final Type actualType = type.getActualTypeArguments()[0];

		System.out.println(actualType);

		final Class<?> cls = (Class<?>)actualType;

		final Field[] fields = cls.getDeclaredFields();

		for (final Field f : fields) {
			System.out.println(f.getName());
		}
	}
}
