<template>
<div class="tablapersonas">
   
        <h1>Mostrar Datos</h1>
         <button class="btn btn-primary" v-on:click="MostrarPersonas">
                  Resultados
         </button>
            
                            <table class="table">
                                <thead></thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Email</th>
                                    <th>documento</th>
                                    <th>Perfil</th>
                                    <th>Acciones</th>
                                </tr>
                                <tr v-for="persona in personas" :key='persona.id'>
                                    <td>{{persona.nombre}}  {{persona.apellido}}</td>
                                    <td>{{persona.email}}</td>
                                    <td>{{persona.numeroDocumento}}  {{persona.tipoDocumento}}</td>
                                    <td>{{persona.perfil}}</td>
                                    <td><button v-on:click="eliminar(persona.id)">Eliminar</button></td>
                                </tr>
                            </table>
                        
           
   
</div>


    
</template>

<script>

export default {
   name:"TablaResultado",
   props:{token:String},
   data(){
       return{
           personas:[]
       }
   },

   methods:{
      async MostrarPersonas(){
          const requestOptions ={
      method: "GET",
      headers: {
        "Authorization": this.token,
        "Content-Type": "application/json"
      }
    };
    const res=await fetch("http://localhost:8081/api/personas", requestOptions);
   
    this.personas=await res.json();
      },

      async eliminar(id){
          const requestOptions={
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": this.token,
                    }
                };
               await fetch(`http://localhost:8081/api/personas/${id}`, requestOptions)
          console.log('se elimino', id)
      }
   }

}
</script>

<style scoped>

</style>
