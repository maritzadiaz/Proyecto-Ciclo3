<template>


    <nav class="navbar navbar-light bg-light">
      
          <div class="container-fluid"><br>
            <form class="d-flex">
              
              <button type="button" class="btn btn-outline-success" v-on:click="agregarpersona">Registrar</button>
              
              <input class="form-control form-control-sm" v-model="id" id="id" type="number">
                <button class="btn btn-primary" v-on:click="buscar">Buscar</button>
                              
            </form>
          </div>
        </nav>
    <form @submit.prevent="enviarFormulario" >
      
      <div class="container">
         <div class=row>
                      
              <div class="col-md-4">
                  <div class="form-group">
                    
                        <input placeholder="Nombre" v-model="persona.nombre" type="text" class="form-control" :class="{ 'is-invalid': procesando && nombreInvalido }"
                            @focus="resetEstado"
                            />
                      </div>
                    </div>
             
              <div class="col-md-4"> 
                  <div class="form-group">
                  
                        <input
                            placeholder="Apellido"
                            v-model="persona.apellido"
                            type="text"
                            class="form-control"
                            :class="{ 'is-invalid': procesando && apellidoInvalido }"
                            @focus="resetEstado"
                        />
                    </div>
                </div>

                   <div class="col-md-4"> 
                              <div class="form-group">
                                  
                                      <select name="perfil" v-model="persona.perfil" class="form-control">
                                          <option value="estudiante">Estudiante</option>
                                          <option value="docente">Docente</option>
                                          <option value="administrativo">Administrativo</option>
                                          <option value="aseo">Personal Serivio Aseo</option>
                                        </select>
                                </div>
                            </div>

                             <div class="col-md-4"> 
                          <div class="form-group">
                              
                                  <label>Tipo De Documento</label>
                                      <select  name="tipoDocumento" v-model="persona.tipoDocumento" class="form-control">
                                          <option value="CC">Cedula De Ciudadania</option>
                                          <option value="TI">Tarjeta Identidad</option>
                                      </select>
                              </div>
                        </div>
          
              
                  <div class="col-md-4"> 
                    <div class="form-group">
                      <label>Numero De Documento</label>
                          <input
                              placeholder="Numero Documento"
                              v-model="persona.numeroDocumento"
                              type="number"
                              class="form-control"
                              :class="{ 'is-invalid': procesando && apellidoInvalido }"
                              @focus="resetEstado"
                            />
                        </div>
                      </div>
              
                               <div class="col-md-4">
                                    <div class="form-group">
                                         <label>Email</label>
                                            <input
                                            placeholder="email"
                                            v-model="persona.email"
                                            type="email"
                                            id="email"
                                            class="form-control"
                                            :class="{ 'is-invalid': procesando && emailInvalido }"
                                            @focus="resetEstado" />
                                        </div>
                                  </div>
                  
                                <div>
                                  <label>Género</label>
                                  <input type="radio" id="femenino" name="genero" v-model="persona.genero" value="f">
                                  <label>Femenino</label>

                                  <input type="radio" id="masculino" name="genero" v-model="persona.genero" value="M">
                                  <label>Masculino</label>
                                
                                </div>
          
                        <div class="col-md-4">
                            <div class="form-group">
                          
                                  <input
                                    placeholder="Talla(Cm)"
                                    v-model="persona.talla"
                                    type="number"
                                    class="form-control"
                                    :class="{ 'is-invalid': procesando && tallaInvalido }"
                                    @focus="resetEstado" />
                              </div>
                          </div>
                          <div class="col-md-4">
                              <div class="form-group">
                                    <input
                                        placeholder="Peso(Kg)"
                                        v-model="persona.peso"
                                        type="number"
                                        class="form-control"
                                        :class="{ 'is-invalid': procesando && pesoInvalido }"
                                        @focus="resetEstado" />
                                </div>
                            </div>
           </div>
                            

                            <div class="row">
                                <div class="col-md-12">
                                    <div v-if="error && procesando" class="alert alert-danger" role="alert">
                                          Debes rellenar todos los campos!
                                      </div>
                                        <div v-if="correcto" class="alert alert-success" role="alert">
                                              La persona ha sido agregada correctamente!
                                          </div>
                                  </div>
                                </div>
        </div>
     </form>
</template>

<script>
  export default {
    name: 'FormularioPersona',
    props: { 
        token: String
    },
    data() {
      return {
        arraypersona:[],
        procesando: false,
         correcto: false,
         error: false,
         persona: {
          fechaRegistro: new Date(),
          nombre: '',
          apellido: '',
          numeroDocumento:'',
          tipoDocumento:'',
          email: '',
          perfil:'',
          talla: '',
          peso: '',
          imc: '',
          genero:'',
          condicion:'',
          recomendacion:''
         
        },

           id:'',
     
      }
    },
    methods:{
        async agregarpersona() {
          this.isenviarformulario= true;
         
           
    this.procesando = true;
    this.resetEstado();

    // Comprobamos la presencia de errores
  if (this.nombreInvalido || this.apellidoInvalido || this.emailInvalido  || this.tallaInvalido || this.pesoInvalido) {
    this.error = true;
    return;
  }

    this.persona.imc=Number((this.persona.peso/(this.persona.talla**2)).toFixed(2))
    console.log(this.persona.imc)

    if (this.persona.imc >=16 && this.persona.imc <= 18.5){
      this.persona.condicion ='Peso Bajo'
      this.persona.recomendacion ='Alimentarse Mejor'

    }
    else if (this.persona.imc >=18.5 && this.persona.imc <= 25){
      this.persona.condicion ='Peso Normal'
      this.persona.recomendacion ='Tienes Vida Saludable'

    }
    else if(this.persona.imc >=25 && this.persona.imc <= 40){
      this.persona.condicion ='Peso Alto'
      this.persona.recomendacion ='Debe Realizar Ejecrcicios y Mejorar su Alimentacion'

    }
    else{
      this.persona.condicion ='Rangos Incorrectos'
      this.persona.recomendacion ='Digite Bien Los Campos'

    }
    
        
    this.$emit('add-persona', this.persona);

    this.error = false;
    this.correcto = true;
    this.procesando = false;

    console.log(this.persona.nombre)
    const datos=JSON.stringify(this.persona);
    console.log(datos)
     
                        
            const requestOptions = {
                method: "POST",
                body: datos,
                headers: {
                    "Authorization": this.token,
                    "Content-Type" : "application/json"
                }
            };
        
            const respuesta =  await fetch("http://localhost:8080/api/personas", requestOptions);
            this.persona = await respuesta.json();
             console.log(this.persona)
            
    // Restablecemos el valor de la variables
    this.persona= {
      fechaRegistro: new Date,
          nombre: '',
          apellido: '',
          numeroDocumento:'',
          tipoDocumento:'',
          email: '',
          perfil:'',
          talla: '',
          peso: '',
           imc: '',
          genero:'',
          condicion:'',
          recomendacion:''
        
      
    }
    this.arraypersona.push(this.persona);
     this.nombre = "";
    this.apellidos = "";
    
  },
  resetEstado() {
    this.correcto = false;
    this.error = false;
  },

  async buscar(){
                ///si esta vacio el campo id, limpio campos y detengo con return
               
                const requestOptions = {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": this.token,
                }
                };
                console.log(this.persona.id)
                const respuesta = await fetch(`http://localhost:8080/api/personas/${this.id}`, requestOptions);
                this.persona = await respuesta.json();
                console.log(this.persona);
                            
            },

},
    computed: {
  nombreInvalido() {
    return this.persona.nombre.length < 1;
  },
  apellidoInvalido() {
    return this.persona.apellido.length < 1;
  },
  emailInvalido() {
    return this.persona.email.length < 1;
  },
},
    }
  
</script>

<style scoped>
  

 
 
 
</style>