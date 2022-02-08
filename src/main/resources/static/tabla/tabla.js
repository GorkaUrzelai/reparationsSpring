//define data array
var tabledata = [
    { Pieza: "Filtro habitaculo", "KM ultimo cambio": 1200, Categoría: "filtros", "Vida útil": 15.000, "KM restantes": 30.000, Estado: 1 },
    { Pieza: "Filtro polen", "KM ultimo cambio": 10200, Categoría: "filtros", "Vida útil": 40.000, "KM restantes": 30.000, Estado: 0 },
    { Pieza: "Filtro combustible", "KM ultimo cambio": 1000, Categoría: "filtros", "Vida útil": 15.000, "KM restantes": 10.000, Estado: 0 },
    { Pieza: "Antinieblas delantero derecho", "KM ultimo cambio": 5000, Categoría: "luces", "Vida útil": 50.000, "KM restantes": 2.000, Estado: 0 },
    { Pieza: "Pinzas freno delantero izquierdo", "KM ultimo cambio": 2500, Categoría: "frenos", "Vida útil": 10.000, "KM restantes": 7.000 ,Estado: 0},
    { Pieza: "Pinzas freno delantero derecho", "KM ultimo cambio": 2500, Categoría: "frenos", "Vida útil": 10.000, "KM restantes": 7.000,Estado: 0 },
    { Pieza: "Antinieblas trasero", "KM ultimo cambio": 5000, Categoría: "luces", "Vida útil": 1000, "KM restantes": 5000, Estado: 1 },
];

var table = new Tabulator("#agrupados", {
    data: tabledata,
    height: "min-content", //aqui esto hay que cambiar, será min cunado no llene toda la pantalla
    //height: "825px",
    layout: "fitColumns",
    groupBy: "Categoría",
    autoColumns: true,
});

table.on("rowClick", function(e, row) {
    window.location = 'home';
});