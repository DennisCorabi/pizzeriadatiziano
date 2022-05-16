export interface Pizza{
  name: string,
  price: number,
  image: string,
  description: string,

}

export const pizze: Pizza[] = [
  {
    name:"Margherita",
    price:10,
    image: "https://www.scattidigusto.it/wp-content/uploads/2018/03/pizza-margherita-originale-Scatti-di-Gusto-1568x821.jpg",
    description: "Pomodoro, mozzarella e basilico",

  },
  {
    name:"Diavola",
    price:12,
    image:"https://wips.plug.it/cips/buonissimo.org/cms/2012/05/69630013_m.jpg?w=713&a=c&h=407",
    description: "Pomodoro, mozzarella e salame piccante",
  },
  {
    name:"Marinara",
    price: 20,
    image: "https://wips.plug.it/cips/buonissimo.org/cms/2012/05/pizza-marinara-5.jpg",
    description: "Pomodoro, olio e basilico"
  }
]
