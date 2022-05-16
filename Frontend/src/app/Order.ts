import {Pizza} from "./Pizza";

export interface Order{
  name: string
  surname: string
  address: string
  phone: string
  pizze: Pizza[]
  price: number
}
