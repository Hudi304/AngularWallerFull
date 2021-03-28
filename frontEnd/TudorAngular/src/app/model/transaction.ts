import { User } from "../user";
import { Currency } from "./currency";

export class Transaction {

    public id!:number;
    public currencie!: Currency
    public amount!: number
    public from!: User
    public to!: User

    public constructor() { }


}
