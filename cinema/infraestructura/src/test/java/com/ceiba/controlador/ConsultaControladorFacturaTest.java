package com.ceiba.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsultaControladorFactura.class)
@ComponentScan("com.ceiba")
public class ConsultaControladorFacturaTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void listar() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/facturas").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				//.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].idFactura", is("FACT-1")));
	}
}
