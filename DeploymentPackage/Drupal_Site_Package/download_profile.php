

 <?php
   
   if(isset($_POST['did'])) 
    {
		
		$table = 'resource_profiles';
		$download_id = $_POST['did'];
		$download_version = $_POST['dv'];
		$q="SELECT * FROM {$table} where id = $download_id and version = $download_version";
		$link = mysqli_connect("localhost", "test", "test","profiles");
		$res = mysqli_query($link,$q);
	   if($res)
	   {
	   $row = mysqli_fetch_assoc($res);
		$id = $row['id'];
		$name = $row['name'];
		$status = $row['status'];
		$content = $row['content'];
		header("Content-type: text/xml");
		header("Content-Disposition: attachment; filename=$name");
		echo $content;
		exit;
	   }
	   else{
	   echo "Cannot download";}
	   echo $_POST['did'];
		echo $_POST['dv'];
	}
	
	?>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!--<meta http-equiv="Content-Type" content="xml"; charset=utf-8" />
-->
</head>

<body>
</body>
</html>