<?php
    $opc=$_POST['opcion'];  // captura el dato que le recive de objetoAJAX
    
    switch ($opc) 
    {
        case "insertar":
            
            $dep=$_POST['departamento'];
            $mun=$_POST['municipio'];
            $nom=$_POST['nombre'];
            $nur=$_POST['numero'];
            
            include 'conexion.php';
            conectar();
            $sql="INSERT INTO suscriptores (departamento, municipio, nombre_prestador, numero_suscriptores) VALUES ('$dep', '$mun', '$nom', '$nur')";
            print $sql;
            mysql_query($sql) or die(mysql_error());
            desconectar();
            break;
        
        case "actualizar":

            $dep=$_POST['departamento'];
            $mun=$_POST['municipio'];
            $nom=$_POST['nombre'];
            $nur=$_POST['numero'];
            
            $olddep=$_POST['olddepartamento'];
            $oldmun=$_POST['oldmunicipio'];
            $oldnom=$_POST['oldnombre'];
            $oldnur=$_POST['oldnumero'];
        
            include 'conexion.php';
            conectar();
            $sql="UPDATE suscriptores 
                SET departamento='$dep', municipio='$mun', nombre_prestador='$nom', numero_suscriptores='$nur' 
                WHERE departamento='$olddep' AND municipio='$oldmun' AND nombre_prestador='$oldnom' AND numero_suscriptores='$oldnur'";
            mysql_query($sql) or die(mysql_error());
            desconectar();
            break;
        
        case "eliminar":
             
            $dep=$_POST['departamento'];
            $mun=$_POST['municipio'];
            $nom=$_POST['nombre'];
            $nur=$_POST['numero'];
            
            include 'conexion.php';
            conectar();
            $sql="DELETE FROM suscriptores 
                WHERE departamento='$dep' AND municipio='$mun' AND nombre_prestador='$nom' AND numero_suscriptores='$nur'";
            mysql_query($sql) or die(mysql_error());
            desconectar();
            break;
        
        case "consultaTabla":
            
            include 'conexion.php';
            conectar();
            $res= mysql_query("select * from suscriptores") or die(mysql_error());   
            desconectar();

            $table_result=array();
            $r=0;

            while($row = mysql_fetch_row($res))
            { 
                $table_result[]= $row;
            }   
            
            echo json_encode($table_result);
            exit;
            break;
    }
?>