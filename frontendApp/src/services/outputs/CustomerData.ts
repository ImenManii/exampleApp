import { TransactionData } from './TransactionData';


export interface CustomerData { 
    name?: string;
    surname?: string;
    balance?: string;
    transactions?: Array<TransactionData>;
}