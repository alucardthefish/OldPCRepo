
<html>
  <head>
    <title>Subiendo Cancion...</title>
  </head>
  
  <body>
    
    <h1>Subir Canciones</h1>
    
    <br /><br />
    
    <form action="upload_file.php" method="post" enctype="multipart/form-data">
    
      Titulo: <input type="text" name="titulo"><br />
      Artista: <input type="text" name="artista"><br />
      Album: <input type="text" name="album"><br />
      Genero: <input type="text" name="genero"><br />
     
      
    
      <label for="file">Filename:</label>
      <input type="file" name="file" id="file" />
      <br />
      <input type="submit" name="submit" value="Submit" />
    </form>
    
  </body>
  
</html>