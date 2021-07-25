<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Slot Assist</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        html, body {
            margin: 0;
            padding: 0;
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

        .content {
            margin: 10vw;
            margin-top: 2vh;
        }
    </style>
</head>

<body>
    <div class="header">Slot Assist - Slot Opening trend for ${location}</div>
    <div class="content">
        <canvas id="visual_chart"></canvas>
    </div>

    <script>
        // === include 'setup' then 'config' above ===
        
        const labels = [
        <#list chartData?keys as key>
        	'${key}',
        </#list>
        ];
        const data = {
            labels: labels,
            datasets: [{
                label: 'Slot',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [
                	<#list chartData?keys as key>
                		'${chartData[key]}',
                	</#list>
                ],
            }]
        };
        const config = {
            type: 'bar',
            data,
            options: {}
        };

        var myChart = new Chart(
            document.getElementById('visual_chart'),
            config
        );
    </script>
</body>

</html>