//define data array
var tabledata = [
    { Pieza: "Oli Bob", "KM ultimo cambio": 12, Categoría: "filtros", "Vida útil": 1, "KM restantes": "30.000", Estado: 1 },
    { Pieza: "Mary May", "KM ultimo cambio": 1, Categoría: "filtros", "Vida útil": 2, "KM restantes": "blue", Estado: true },
    { Pieza: "Christine Lobowski", "KM ultimo cambio": 42, Categoría: "luces", "Vida útil": 0, "KM restantes": "green", Estado: "true" },
    { Pieza: "Brendon Philips", "KM ultimo cambio": 100, Categoría: "frenos", "Vida útil": 1, "KM restantes": "orange" },
    { Pieza: "Margret Marmajuke", "KM ultimo cambio": 16, Categoría: "frenos", "Vida útil": 5, "KM restantes": "yellow" },
    { Pieza: "Christine Lobowski", "KM ultimo cambio": 42, Categoría: "luces", "Vida útil": 0, "KM restantes": "green", Estado: "true" },
    { Pieza: "Brendon Philips", "KM ultimo cambio": 100, Categoría: "frenos", "Vida útil": 1, "KM restantes": "orange" },
    { Pieza: "Margret Marmajuke", "KM ultimo cambio": 16, Categoría: "frenos", "Vida útil": 5, "KM restantes": "yellow" }, { Pieza: "Christine Lobowski", "KM ultimo cambio": 42, Categoría: "luces", "Vida útil": 0, "KM restantes": "green", Estado: "true" },
    { Pieza: "Brendon Philips", "KM ultimo cambio": 100, Categoría: "frenos", "Vida útil": 1, "KM restantes": "orange" },
    { Pieza: "Margret Marmajuke", "KM ultimo cambio": 16, Categoría: "frenos", "Vida útil": 5, "KM restantes": "yellow" }, { Pieza: "Christine Lobowski", "KM ultimo cambio": 42, Categoría: "luces", "Vida útil": 0, "KM restantes": "green", Estado: "true" },

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
    window.location = 'index.html';
});