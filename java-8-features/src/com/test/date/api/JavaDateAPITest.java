package com.test.date.api;

import static org.hamcrest.CoreMatchers.anything;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.java.date.api.JavaDateAPI;

class JavaDateAPITest {

	private JavaDateAPI dateApi = new JavaDateAPI();
	// LocalDate localDate = mock(LocalDate.class);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		// when(localDate.now()).thenReturn(LocalDate.now());
		when(dateApi.checkDate(eq(LocalDate.now()), anyString())).thenReturn(5);
		assertEquals(5, dateApi.checkDate(LocalDate.now(), "sale1"));
	}

}
