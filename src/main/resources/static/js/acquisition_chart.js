const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: [0,1,2,3,4,5,6,7,8,9],
        datasets: [{
            label: 'Number of Acquisitions',
            data: acquisitionsData,
            borderColor: 'rgba(255, 99, 132, 1)',
            backgroundColor:'rgba(255, 99, 132, 0.2)',
            fill: '+2'
        }]
    },
    options: {
        plugins: {
        title: {
            display: true,
            text: startupName
        }
    },

        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
