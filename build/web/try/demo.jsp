<html>
	<head>
		<title></title>
                <script type="text/javascript" src="../js/jquery-min.js"></script>
                <script type="text/javascript" src="../js/tooltip.jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.tooltip').tooltip({
							folderurl : 'trial.jsp'
							});
				$('.tooltip2').tooltip();	
				$('.tooltip3').tooltip({
							folderurl : 'contents/'
							});
				$('.tooltip4').tooltip();
				$('.tooltip5').tooltip({width: '250px'});
				$('.tooltip6').tooltip({width: '250px', height: '75px'});
				$('.tooltip7').tooltip({cursor: 'wait'});					
			});
		</script>
	</head>
<body>
<a  id="?Album_id=2" class="tooltip">Testing no 1 </a>

</body>
</html>
