
<template>
       
      <img src="./assets/LogoUnab.png" width="400" height="150" />
     <div id="app" class="container" >
          <div class="row">
              <div class="col-md-12"><br>
                <h2>Calcular IMC</h2>
                <h3>Ingrese Tus Datos</h3>
              </div>
            </div>
       <div class="row">
      <div class="col-md-12">
        <FormularioPersona :token ="token"/>
        <TablaResultado :token ="token"/>
      </div>
    </div>
  </div>

  <footer>EQUIPO #1 GRUPO G-36 MARITZA DIAZ - MARLACAMACHO - GUSTAVOTORO</footer>
  
</template>
<script>
  
  import FormularioPersona from '@/components/FormularioPersona.vue'
  import TablaResultado from '@/components/TablaResultado.vue'

  export default {
    name: 'app',
    components: {
      FormularioPersona,
      TablaResultado
    },
    data() {
      return {
      token: 'application/json',
     
    };
    
  },
  async beforeCreate(){
    const requestOptions ={
      method: "POST",
      body: JSON.stringify({"id": 7}),
      headers: {
        "Content-Type": "application/json"
      }
    };
    fetch("http://localhost:8080/api/auth", requestOptions)
    .then(async response=>{
      const data = await response.json();
      if(!response.ok){
        const error = (data && data.message) || response.status;
        return Promise.reject(error);
      }
      this.token = data.token;
    })
    .catch(error=> {
      this.token = error;
      console.error('Error al consultar token!', error);
    });
  },
  methods:{
   
  },
  }
  
  
</script>

<style>
   
      
  h{
    text-align: center;
    border-radius: 20px;
    background-color: aliceblue;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif
  }

  footer{
    text-align: center;
    border-radius: 20px;
    background-color: aliceblue;
    height: 50px;
  }

 
 
</style>