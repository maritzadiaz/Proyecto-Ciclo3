
<template>
       
      
     <div id="app" class="container" >
          <div class="row">
              <div class="col-md-12"><br>
              <center><img src="./assets/LogoUnab.png"  /></center>
                <center><h2 >Registro Para Prueba de Tamizaje Usuarios Unab</h2></center>
                <center><h3>Ingrese Sus Datos</h3></center>
              </div>
            </div>
       <div class="row">
      <div class="col-md-12">
        <FormularioPersona :token ="token"/>
        <TablaResultado :token ="token"/>
      </div>
    </div>
  </div>
  
  <div class="fixed-bottom"  >
     <footer ><h5>EQUIPO #1 GRUPO G-36</h5> 
     <h6>MARITZA DIAZ - MARLA CAMACHO - GUSTAVO TORO</h6>
    </footer>
  </div>
  
  
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
      body: JSON.stringify({"id": 10}),
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
   
   img{
  max-width: 25%;
  height: auto;
  
  
   }
  h{
    text-align: center;
    border-radius: 20px;
    background-color: aliceblue;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif
    
  }

  footer{
    text-align: center;
     height: 50px;
  }

 
 
</style>