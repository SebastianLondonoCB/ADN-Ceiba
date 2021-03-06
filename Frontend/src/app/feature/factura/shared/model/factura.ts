import { DetalleFactura } from './detalleFactura';

export class Factura {
    idFactura: number;
	identificacionCliente: string;
	fechaFactura: Date;
    plazoFactura: number;
	fechaVencimiento: Date;
	subtotalFactura: number;
	ivaFactura: number;
	descuentosFactura: number;
	totalFactura: number;
	utilidadFactura: number;
    detalleFactura: DetalleFactura[];
}
