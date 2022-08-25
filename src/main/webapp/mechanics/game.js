window.onload = start;

function start() {
    let cells;

    for(i = 0; i < 42; i++) {
        cells += '<div class="cell"></div>';
    }

    document.getElementById("board").innerHTML = cells;
}