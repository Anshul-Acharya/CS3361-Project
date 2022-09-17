/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildparser;


/**
 *
 * @author anshu and jorge
 */
public class Parser {
      public Parser(){
    
}
    
    
    public  void Parser(String[] data){               //THIS IS THE PARSER FUNCTION
        readStatement(data);
        writeStatement(data);
        idAssign(data);
    }
    
    
 /***************************************PROGRAMS FOR TOKENS*********************************/
    
    
    public void programStart(){                        
       String programStart = "<program>";
       System.out.println(programStart);
    }
    
    /******************STMT FUNCTIONS*****************/
      public void stmtList(){                        
          System.out.println(" <stmt_list>");
      }
     public void stmtListEnd(){                        
          System.out.println(" </stmt_list>");
      }
    public void stmt(){
        System.out.println("  <stmt>");
       
    }
     public  void stmtEnd(){
        System.out.println("  </stmt>");
    } 
     
    /*************READ FUNCTIONS******************/
    public  void read(){                                  
          System.out.println("         <read>");
      } 
    
    public  void readEnd(){
          System.out.println("         </read>");
      } 
       
    /***************ID FUNCTIONS*******************/
    public  void id(){                 
          System.out.println("         <id>");
           }
    public  void idEnd(){
          System.out.println("         </id>");
      }
     
    /*****************ASSIGN FUNCTIONS*************/
    public  void assign(){                             
          System.out.println("         <assign>");
      }
     public  void assignEnd(){
          System.out.println("         </assign>");
      }
     
     
    /******************ADD OP FUNCTIONS***************/
    public  void add_op(){                             //add operator
          System.out.println("         <add_op>");
      }
    
     public void add_opEnd(){
          System.out.println("         </add_op>");
      }
     
     
     /*****************WRITE FUNCTIONS******************/
     public  void write(){
        System.out.println("          <write>");
    }
       public  void writeEnd(){
        System.out.println("          </write>");
    }
     
       
     /******************EXPR FUNCTIONS*****************/
      public  void expr(){                                  
        System.out.println("    <expr>");
    }
     
      public void exprEnd(){
        System.out.println("    </expr>");
    }
      
      /*****************TERM DISPLAY FUNCTIONS*********/
      public void term(){                                 
          System.out.println("     <term>");
      }
      public void termtail(){
          System.out.println("      <term_tail>");
      }
       public void termtailEnd(){
           System.out.println("        </termtail>");
       }
       
       public void termEnd(){
          System.out.println("  </term>");
      } 
       
       /*********************FACTOR FUNCTIONS**************/
      public void factor(){                                    
           System.out.println("        </factor>");
       }
      public void factortail(){
           System.out.println("      <factortail>");
       }
      public void factortailEnd(){
           System.out.println("        </factortail>");
       }
      public void factorEnd(){
           System.out.println("        </factor>");
       }
     
      
      /***************MULT OP FUNCTIONS******************/
      public  void mult_op(){
          System.out.println("         <mult_op>");
      }
      
      public  void mult_opEnd(){
          System.out.println("        </mult_op>");
      }
           
      /*****************NUMBER FUNCTIONS*****************/     
      public  void number(){
          System.out.println("         <number>");
      }
           public  void numberEnd(){
          System.out.println("         </number>");
      }
           
      /****************PARENTHESIS FUNCTIONS************/     
     public  void lparen(){
               System.out.println("         <lparen");
           }
           
     public  void rparen(){
               System.out.println("         <rparen>");
           }
           
     public void lparenEnd(){
               System.out.println("         </lparen>");
           }
       
    public  void rparenEnd(){
               System.out.println("         </rparen>");
           }
           
      
  
    
    
     

     
    public  void programEnd(){
        stmtList();
        stmtListEnd();
        String programEnd = " </stmt_list> \n</program>";
        System.out.println(programEnd);
    }
    
   
    
    //********************************** ACTIONS******************************************/
    public  boolean add_op(String data){
        if(data.equals("+")||data.equals("-")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public  boolean assign(String data){
          
        if(data.equals(":=")){
            return true;
        }
        
        else
            return false;
    }
    
    public  boolean mult_op(String data){
        if(data.equals("*")||data.equals("/")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public  boolean id(String data){
        if( data.matches("[A-Za-z]*[0-9]*") && !number(data)&&!read(data) &&!write(data)){
            return true;
        }
        else
            return false;
    }
    
    public  boolean number(String data){
        if( data.matches(".*[0-9].*")){
            return true;
        }
            else
            return false;
        }
    
    public  boolean read(String data){
        if(data.equals("read")){
            return true;
        }
        else
            return false;
    }
    
    public  boolean write(String data){
        if(data.equals("write")){
            return true;
        }
        else
            return false;
    }
    
    
    
    
    
    
    //*********************************** CALLING MAIN METHOD********************************************//
     int i;
    public  void readStatement(String [] data){
        for (i = 0; i<data.length; i++){
                  
                 if(data.length==1)                          //only one data makes no valid expression
                      System.exit(0);
         while((read(data[i])==true) && i==0){
             stmtList();
                          stmt();
                          read();
                           System.out.println("          "+data[i]);
                           readEnd();
                           i++;
                           if(id(data[i])==true){
                           id();
                           System.out.println("          "+data[i]);
                           idEnd();
                           }
                           
                           else if(number(data[i])==true){
                           number();
                           System.out.println("          "+data[i]);
                           numberEnd();
                           }
                           else
                           {
                               System.out.println("........ERROR.......");
                               System.exit(0);
                           }
                           stmtEnd();
                           break;
                       }
    }
        
    }
    
    
    public  void writeStatement( String[] data){
        for (i = 0; i<data.length; i++){
                  
                 if(data.length==1)                         
                      System.exit(0);
                       while((write(data[i])==true) && i==0 )
                       {
                           stmtList();
                           stmt();
                           write();
                           System.out.println("           "+data[i]);
                            i++;
                           writeEnd();
                          
                           expr();
                           term();
                           factor();
                           if(!data[i].equals("(") && !id(data[i])== true && !number(data[i])==true){
                               System.out.println(".......ERROR.......");
                               System.exit(0);
                           }
                           
                  /**************************************** ID  ***************************************/        
                           if(id(data[i])==true){
                           id();
                           System.out.println("          "+data[i]);
                           idEnd();
                         if(i<data.length && i != (data.length -1)){
                                   i++;
                               }
                           if(add_op(data[i])==true  || mult_op(data[i])==true){
                               if(add_op(data[i])==true){
                               add_op();
                           System.out.println("          "+data[i]);
                           i++;
                           add_opEnd();
                               }
                               else if (mult_op(data[i])==true){
                                   mult_op();
                           System.out.println("          "+data[i]);
                           i++;
                           mult_opEnd();
                               }
                               else{
                                   System.out.println(" Operator needed.");
                                   System.exit(0);
                               }
                           }
                           
                           if(id(data[i])==true){
                               id();
                               System.out.println("          "+data[i]);
                               idEnd();
                           }
                           
                           else if (number(data[i]) == true){
                               number();
                                  System.out.println("          "+data[i]);
                                  numberEnd();
                           }
                               }
                           
                           //****************************************************ID part ended up*********************
                   
                           if(data[i].equals("(")){
                              
                               lparen();
                               System.out.println("          "+data[i]);
                                i++;
                               lparenEnd();
                               
                               if(id(data[i])==true){
                                
                           id();
                           System.out.println("          "+data[i]);
                            i++;
                           idEnd();
                          
                           if(add_op(data[i])==true  || mult_op(data[i])==true){
                               if(add_op(data[i])==true){
                               add_op();
                           System.out.println("          "+data[i]);
                           i++;
                           add_opEnd();
                               }
                               else if (mult_op(data[i])==true){
                                   mult_op();
                           System.out.println("          "+data[i]);
                           i++;
                           mult_opEnd();
                               }
                           }
                           
                           if(id(data[i])==true){
                               id();
                               System.out.println("          "+data[i]);
                               i++;
                               idEnd();
                           }
                           
                           else if (number(data[i]) == true){
                               number();
                                  System.out.println("          "+data[i]);
                                   i++;
                                  numberEnd();
                           }
                           
                           if(data[i].equals(")")){
                               rparen();
                               System.out.println("          "+data[i]);
                               rparenEnd();
                           }
                               }
                               
                               else
                               {
                                   System.out.println(".....Error.....");
                               System.exit(0);
                               }
                               
                           }
                           //Expression with parantheses 
                        
                           
                           
                               else if (number(data[i])==true && (i != (data.length-1))){
                                   number();
                               System.out.println("          "+data[i]);
                               numberEnd();
                               
                               if(i<data.length && i != (data.length -1)){
                                   i++;
                               }
                               
                               if(i == data.length)
                                   break;
                           if(add_op(data[i])==true  || mult_op(data[i])==true ){
                               if(add_op(data[i])==true){
                               add_op();
                           System.out.println("          "+data[i]);
                           i++;
                           add_opEnd();
                               }
                               else if (mult_op(data[i])==true){
                                   mult_op();
                           System.out.println("          "+data[i]);
                           i++;
                           mult_opEnd();
                               }
                               else{
                                   System.out.println(" Operator needed.");
                                   System.exit(0);
                               }
                           }
                           
                           if(id(data[i])==true){
                               id();
                               System.out.println("          "+data[i]);
                               idEnd();
                           }
                           
                           else if (number(data[i]) == true){
                               number();
                                  System.out.println("          "+data[i]);
                                  numberEnd();
                           }
                           if(i == (data.length-1)){
                           break;
                           }
                           }
                           exprEnd();
                           termEnd();
                           break;
                       }
    }       
    }
    
    
    public  void idAssign( String[] data){
        for (i = 0; i<data.length; i++){
                  
                 if(data.length==1)                          //only one data makes no valid expression
                      System.exit(0);
           while((id(data[i])==true) && i==0){
               stmtList();
                           stmt();
                          id();
                           System.out.println("          "+data[i]);
                           i++;
                           idEnd();
                           
                           if(assign(data[i])==true){
                               assign();
                               System.out.println("          "+data[i]);
                               i++;
                               assignEnd();
                               
                               while(id(data[i])== true || number(data[i])== true){
                                   if(id(data[i])== true){
                                       id();
                                       System.out.println("          "+data[i]);
                                       idEnd();
                                       
                                       if(i<(data.length-1)){
                                           i++;
                                           if(!add_op(data[i])==true && !mult_op(data[i])==true){
                                               System.out.println("..........Parsing line 472 Error......");
                                               System.exit(0);
                                           }
                                           else if (add_op(data[i])==true){
                                               add_op();
                                               System.out.println("          "+data[i]);
                                               add_opEnd();
                                               
                                               if(i<data.length ){
                                                   i++;
                                                   if(add_op(data[i])== true || mult_op(data[i])==true){
                                                    System.out.println("..........Parsing line 483 Error......");
                                               System.exit(0);   
                                                   }
                                               }
                                           }
                                           
                                           else if (mult_op(data[i])==true){
                                               mult_op();
                                               System.out.println("          "+data[i]);
                                               mult_opEnd();
                                               
                                               if(i<data.length){
                                                   i++;
                                                   if(add_op(data[i])== true || mult_op(data[i])==true){
                                                    System.out.println("..........Parsing /Error......");
                                               System.exit(0);   
                                                   }
                                               }
                                               
                                           }
                                           if(i ==(data.length-1)){
                                               if( id(data[i])){
                                                   id();
                                                   System.out.println("          "+data[i]);
                                                   idEnd();
                                               }
                                           
                                                   break;
                                           }
                                           else
                                           continue;
                                       }
                                   }
                                   
                                   else if(number(data[i])==true){
                                       number();
                                       System.out.println("          "+data[i]);
                                       number();
                                   }
                               }
                               
                           }
                           
                           else{
                               System.out.println("An error was encountered...//.. Now Exitting");
                               System.exit(0);
                           }
                           
                       }
                       
    }        
    }
    
}
