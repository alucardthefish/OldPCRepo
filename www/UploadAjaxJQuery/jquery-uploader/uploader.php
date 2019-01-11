<?php
if (!empty($_FILES)) {
	$tempFile = $_FILES['Filedata']['tmp_name'];
	$file_name = $_FILES['Filedata']['name'];	
	$targetPath = $_SERVER['DOCUMENT_ROOT'] . $_REQUEST['folder'] . '/';
	$targetFile =  str_replace('//','/',$targetPath) . $file_name;	
	if (move_uploaded_file($tempFile,$targetFile)){
		echo 'Tu archivo se subió correctamente '.@$_POST['texto'];
	} else {
		echo 'Tu archivo falló';
	}
}
?>