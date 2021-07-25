<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Slot Assitant</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">



    <style>
        html,body {
            padding: 0;
            margin: 0;
            width: 100vw;
            font-family: Arial, Helvetica, sans-serif;
        }
        .header {
            width: 100vw;
            text-align: center;
            font-size: 28px;
            font-weight: bolder;
            background-color: #f1f1f1;
            padding: 20px 10px;
        }
        .body-content {
            width: 100vw;
            padding-left: 5vw;
            padding-right: 5vw;
            text-align: center;
        }

        form {
           max-width: 50vw;
           min-width: 400px;
            margin: auto;
            padding: 10%;
            
        }
    
    </style>
    
    <script>
    	function updateCenterInPath() {
    	
    		document.getElementById('data_form').action = "visualize/" + document.getElementById("location-selection").value.trim();
    	}
    
    </script>
</head>
<body onload="updateCenterInPath();">
    <div class="header">
        Slot Assist
    </div>
    <div class="body-content">
        <form id="data_form" action="visualize" method="GET">
            <div class="form-group">
                <label for="district-selection">Select a District</label>
                <select class="form-control" name="" id="district-selection">
                <#list districts as district >
                    <option value="${district}">${district}</option>
                </#list>
                </select>
            </div>

            <div class="form-group">
                <label for="location-selection">Select Location</label>
                <select class="form-control" name="" id="location-selection" onchange="updateCenterInPath();">
                <#list centers as center >
                    <option value="${center}">${center}</option>
                 </#list>
                </select>
            </div>
            
           
           <button class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="footer"></div>
    
</body>
</html>