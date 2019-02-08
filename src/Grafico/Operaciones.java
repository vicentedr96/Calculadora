/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

/**
 *
 * @author vicen
 */
public class Operaciones {
    
    int contador=0;
    
public double eliminarSigno(String numero){

String numero1=numero.substring(1);
return Double.parseDouble(numero1); 

} //elimina el signo de la poscion 0 

public int posicion(String dato,int  x10){//encontrar posicion a partir de n lugar
int nS=0,nM=0,nD=0,nR=0;
int id=1;
        
if(dato.matches(".*[+].*")||dato.matches(".*[-].*")||dato.matches(".*[*].*")||dato.matches(".*[/].*")){
nS=dato.indexOf("+",x10);
nM=dato.indexOf("*",x10);
nD=dato.indexOf("/",x10);
nR=dato.indexOf("-",x10);

if(nS==-1){
nS=100;
}
if(nR==-1){
nR=100;
}
if(nM==-1){
nM=100;
}
if(nD==-1){
nD=100;
}

if(nS==100 && nR==100 && nM==100 && nD==100){
   
return 99;
}else{
int min = nS;
if (nR< min ){
min = nR;
}
if (nM< min) {
min = nM;
}
if (nD< min) {
min = nD;
}
return min;
}
}else{
id=99;
return id;
} 
        
} //retorna la posicion a partir n lugar

public int localizar(String dato){// localizo el primer signo detectado y 
                                      //lo envio con id (nS 1  nR 2  nM 3 nD 4)
  String copia=dato;
  int nS=0,nM=0,nD=0,nR=0;
  int id=1;
  try{
  copia=copia.substring(0,this.posicion(copia, 1));// perso se salta un digito
  }catch(Exception ex){}
  
  if(copia.matches(".*[+].*")||copia.matches(".*[-].*")||copia.matches(".*[*].*")||copia.matches(".*[/].*")){
  nS=dato.indexOf("+");
  nM=dato.indexOf("*");
  nD=dato.indexOf("/");
  nR=dato.indexOf("-");   //ellos me daran algunos menos -1 en caso de no los encuentre
  
  if(nS==-1){
  nS=100; }
  if(nR==-1){
  nR=100;
  }
  if(nM==-1){
  nM=100;
  }
  if(nD==-1){
  nD=100; } 
  
  int min = nS;
  if (nR< min ){
  min = nR;
  id=2;
  }
  //identifica el id correto al primer signo
  if(nM< min) {
  min = nM;
  id=3;
  }
  if (nD< min) {
  min = nD;
  id=4;
  }
  return id;
  
  }else{//se asume que es positivo
  return  id=1;
  }           
    
} //localizo el primer signo detectado 

public double operacion(String dato){

            this.contador=0;   
            String  copia=dato;
            double resultado=0;
            String num1;
try{


            for (int i = 0; i <dato.length(); i++) {    
            if(!copia.equals("")){
            int x=this.localizar(copia);
            switch(x){//

    case 1:// suma

             if(contador==0){
             num1=copia.substring(0,this.posicion(copia, 1));
 
             if(num1.matches(".*[+].*")||num1.matches(".*[-].*")||num1.matches(".*[*].*")||num1.matches(".*[/].*")){//empieza con signo
                 
             num1=copia.substring(0,this.posicion(copia,1)); 
             resultado+=this.eliminarSigno(num1);
             copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");
             copia=copia.replaceFirst("[+]","");
            
             }else{
             
             num1=copia.substring(0,this.posicion(copia, 0));//empieza sin signo
             copia=copia.replaceFirst(num1+"","");
             resultado+=Double.parseDouble(num1); 
             }}else{
         
         
            if(this.posicion(copia,1)==99){                  // es decir el sin signo al final, arregla aqui<--------------
            resultado+=Double.parseDouble(copia.substring(1));
            copia=copia.replaceFirst(copia.substring(1), "");
            copia=copia.replaceFirst("[+]","");
            
            }else{
                
            num1=copia.substring(0,this.posicion(copia,1)); 
            resultado+=this.eliminarSigno(num1);
            copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");//sucesivo
            copia=copia.replaceFirst("[+]","");
            }
        }
    contador++;
    break;
          
    case 2://resta

             if(contador==0){
             num1=copia.substring(0,this.posicion(copia, 1));
 
             if(num1.matches(".*[+].*")||num1.matches(".*[-].*")||num1.matches(".*[*].*")||num1.matches(".*[/].*")){//empieza con signo
                 
             num1=copia.substring(0,this.posicion(copia,1)); 
             resultado-=this.eliminarSigno(num1);
             copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");
             copia=copia.replaceFirst("[-]","");
            
             }else{
             
             num1=copia.substring(0,this.posicion(copia, 0));//empieza sin signo
             copia=copia.replaceFirst(num1+"","");
             resultado-=Double.parseDouble(num1); 
             }}else{
         
         
            if(this.posicion(copia,1)==99){    
            resultado-=Double.parseDouble(copia.substring(1));
            copia=copia.replaceFirst(copia.substring(1), "");
            copia=copia.replaceFirst("[-]","");
            
            }else{
                
            num1=copia.substring(0,this.posicion(copia,1)); 
            resultado-=this.eliminarSigno(num1);
            copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");//sucesivo
            copia=copia.replaceFirst("[-]","");
            }
        }
    contador++;
              
    
    break;
    
    case 3://multiplicacion
            if(contador==0){
             num1=copia.substring(0,this.posicion(copia, 1));
 
             if(num1.matches(".*[+].*")||num1.matches(".*[-].*")||num1.matches(".*[*].*")||num1.matches(".*[/].*")){//empieza con signo
                 
             num1=copia.substring(0,this.posicion(copia,1)); 
             resultado*=this.eliminarSigno(num1);
             copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");
             copia=copia.replaceFirst("[*]","");
            
             }else{
             
             num1=copia.substring(0,this.posicion(copia, 0));//empieza sin signo
             copia=copia.replaceFirst(num1+"","");
             resultado*=Double.parseDouble(num1); 
             }}else{
         
         
            if(this.posicion(copia,1)==99){                  // es decir el sin signo al final, arregla aqui<--------------
            resultado*=Double.parseDouble(copia.substring(1));
            copia=copia.replaceFirst(copia.substring(1), "");
            copia=copia.replaceFirst("[*]","");
            
            }else{
                
            num1=copia.substring(0,this.posicion(copia,1)); 
            resultado*=this.eliminarSigno(num1);
            copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");//sucesivo
            copia=copia.replaceFirst("[*]","");
            }
        }
    contador++;     
        
    break;
    
    case 4://division
     if(contador==0){
             num1=copia.substring(0,this.posicion(copia, 1));
 
             if(num1.matches(".*[+].*")||num1.matches(".*[-].*")||num1.matches(".*[*].*")||num1.matches(".*[/].*")){//empieza con signo
                 
             num1=copia.substring(0,this.posicion(copia,1)); 
             resultado/=this.eliminarSigno(num1);
             copia=copia.replaceFirst(copia.substring(1,this.posicion(copia,1))+"","");
             copia=copia.replaceFirst("[/]","");
            
             }else{
             
             num1=copia.substring(0,this.posicion(copia, 0));//empieza sin signo
             copia=copia.replaceFirst(num1+"","");
             resultado/=Double.parseDouble(num1); 
             }}else{
         
         
            if(this.posicion(copia,1)==99){                  // es decir el sin signo al final, arregla aqui<--------------
            resultado/=Double.parseDouble(copia.substring(1));
            copia=copia.replaceFirst(copia.substring(1), "");
            copia=copia.replaceFirst("[/]","");
            
            }else{}}}}}
            
}catch(Exception ex){
    
  
}
        return resultado;
}
}
                
     