package com.ceiba.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.comando.ComandoDetalleFactura;
import com.ceiba.testdatabuilder.ComandoDetalleFacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ComandoControladorFactura.class)
@ComponentScan("com.ceiba")
public class ComandoControladorDetalleFacturaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void crear() throws Exception {
		// arrange
		ComandoDetalleFactura comandoDetalleFactura = new ComandoDetalleFacturaTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/detalles_facturas").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoDetalleFactura))).andExpect(status().isOk());
	}
}
