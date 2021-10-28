<template>
<div class="tablapersonas">
   
        <center><h2>Mostrar Datos</h2></center>

              
              <center> <button  class="btn btn-outline-warning "   v-on:click="MostrarPersonas"> Resultados
                        </button> </center>
          
                    
                            <table class="table">
                                
                                <tr>
                                    <th>Nombre</th>
                                    <th>Talla</th>
                                   ne <th>Peso</th>
                                    <th>IMC</th>
                                    <th>Condicion</th>
                                    <th>Recomendaciones</th>
                                    <th>Acciones</th>
                                </tr>
                                <tr v-for="persona in personas" :key='persona.id'>
                                    <td>{{persona.nombre}}  {{persona.apellido}}</td>
                                    <td>{{persona.talla}}</td>
                                    <td>{{persona.peso}} </td>
                                    <td>{{persona.imc}}</td>
                                    <td>{{persona.condicion}}</td>
                                    <td>{{persona.recomendacion}}</td>
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
                const requestOptions={
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": this.token,
                    }
                };
                const respuesta = await fetch("http://localhost:8080/api/personas", requestOptions)
                this.personas = await respuesta.json();
               
            },

            async eliminar(id){
                const requestOptions={
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": this.token,
                    }
                };
               await fetch(`http://localhost:8080/api/personas/${id}`, requestOptions)
                ////actualizar la tabla para que desaparezca el eliminado
                this.MostrarPersonas();
            }
   }


}
</script>

<style scoped>

</style>
