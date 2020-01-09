import { element, by } from 'protractor'

export class clientesPages {

    private btnRegistrarCliente = element(by.xpath('/html/body/app-root/app-cliente/nav/button'));
    private btnGuardarCliente = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[5]/button[1]'));

    private selectCedulaCiudadania = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[1]/div[1]/div/select/option[1]'));
    private selectNit = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[1]/div[1]/div/select/option[2]'));    
    private selectTarjetaIdentidad = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[1]/div[1]/div/select/option[3]'));
    private selectOtro = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[1]/div[1]/div/select/option[4]'));
    
    private inputIdentificacion = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[1]/div[2]/div/input'));
    private inputNombres = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[2]/div[1]/div/input'));
    private inputApellidos = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[2]/div[2]/div/input'));
    private inputTipoCliente = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[3]/div[1]/div/input'));
    private inputTelefono = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[3]/div[2]/div/input'));
    private inputEmail = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[4]/div[1]/div/input'));
    private inputFechaNacimiento = element(by.xpath('/html/body/app-root/app-cliente/app-crear-cliente/div/div/div[2]/form/div[4]/div[2]/div/input'));

    public clickBtnRegistrarCliente() {
        this.btnRegistrarCliente.click(); 
    } 

    public seleccionarCedulaCiudadania() {
        this.selectCedulaCiudadania.click();
    } 

    public seleccionarNit() {
        this.selectNit.click();
    } 

    public seleccionarTarjetaIdentidad() {
        this.selectTarjetaIdentidad.click();
    } 

    public seleccionarOtro() {
        this.selectOtro.click();
    } 

    public llenarInputIdentificacion(identificacion: string) {
        this.inputIdentificacion.sendKeys(identificacion); 
    } 

    public llenarInputNombres(nombres: string) {
        this.inputNombres.sendKeys(nombres); 
    } 

    public llenarInputApellidos(apellidos: string) {
        this.inputApellidos.sendKeys(apellidos); 
    } 

    public llenarInputTipoCliente(tipoCliente: string) {
        this.inputTipoCliente.sendKeys(tipoCliente); 
    } 

    public llenarInputTelefono(telefono: string) {
        this.inputTelefono.sendKeys(telefono); 
    } 

    public llenarInputEmail(email: string) {
        this.inputEmail.sendKeys(email); 
    } 

    public llenarInputFechaNacimiento(fechaNacimiento: string) {
        this.inputFechaNacimiento.sendKeys(fechaNacimiento); 
    } 

    public clickBtnGuardarCliente() {
        this.btnGuardarCliente.click(); 
    } 
}