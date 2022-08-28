function start() {
    let cells = "";

    for(i = 0; i < 42; i++) {
        cells += '<div class="cell" id="' + i + '"></div>';
        if(i%7==6)
            cells += '<div style="clear:both"></div>';

    }

    document.getElementById("board").innerHTML = cells;
}

window.onload = start;