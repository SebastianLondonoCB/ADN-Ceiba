import { clientesPages } from '../pages/crear-clientes';
import { browser } from 'protractor';

describe('Este es el paso a paso para el registro de un cliente', () => { 
    const cliente = new clientesPages();                                                                      

    it('Le damos clic en el botón de Registrar producto', () => { 
        browser.get('http://localhost:4200/cliente/listar');                        
        cliente.clickBtnRegistrarCliente();
    })

    it('Seleccionamos el tipo de identificacion', () => {                       
        cliente.seleccionarTarjetaIdentidad();
    })

    it('Llenamos el campo de identificacion', () => {                       
        cliente.llenarInputIdentificacion("96030417949");
    })

    it('Llenamos el campo de nombres', () => {                       
        cliente.llenarInputNombres("Juan Diego");
    })

    it('Llenamos el campo de apellidos', () => {                       
        cliente.llenarInputApellidos("Zapata");
    })

    it('Llenamos el campo de tipo de cliente', () => {                       
        cliente.llenarInputTipoCliente("VIP");
    })

    it('Llenamos el campo de telefono', () => {                       
        cliente.llenarInputTelefono("3118313250");
    })

    it('Llenamos el campo de email', () => {                       
        cliente.llenarInputEmail("juandiego-96-@hotmail.com");
    })

    it('Llenamos el campo de fecha de nacimiento', () => {                       
        cliente.llenarInputFechaNacimiento("01011998");
    })

    it('Le damos clic en el botón de guardar cliente', () => {                      
        cliente.clickBtnGuardarCliente();
    })
})