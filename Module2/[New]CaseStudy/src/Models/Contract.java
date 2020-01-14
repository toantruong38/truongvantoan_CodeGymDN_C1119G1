package Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Contract implements ShowInformation
{
    public final static String CONTRACT_LABEL = "contractNumber,startDay,endDay,deposit,totalPay";

    private String contractNumber;

    private String startDay;

    private String endDay;

    private long deposit;

    private long totalPay;

    public static Contract setContractInformation()
    {
        Contract contract = new Contract();
        Scanner input = new Scanner(System.in);

        System.out.printf("Contract number: ");
        contract.setContractNumber(input.nextLine());

        System.out.printf("Contract starts day: ");
        contract.setStartDay(input.nextLine());

        System.out.printf("Contract ends day: ");
        contract.setEndDay(input.nextLine());

        System.out.printf("Contract deposit: ");
        contract.setDeposit(input.nextLong());

        System.out.printf("Contract total pay: ");
        contract.setTotalPay(input.nextLong());

        return contract;
    }

//    public ArrayList<Contract> import_from_file(String url)
//    {
//        String data_to_file=this.CONTRACT_LABEL;
//
//        ArrayList<Contract> contracts=new ArrayList<>();
//        ArrayList<Object> formatted_data_by_line= FuncWriteFileCSV.readFile(url);
//
//        for(int line=1;line<formatted_data_by_line.size();line++)
//        {
//
//        }
//    }

    public static Contract setContractInformation(ArrayList<Object> contract_data)
    {
        Contract contract = new Contract();
        Iterator iterator = contract_data.iterator();

        contract.setContractNumber(iterator.next().toString());
        contract.setStartDay(iterator.next().toString());
        contract.setEndDay(iterator.next().toString());
        contract.setDeposit(Long.valueOf(iterator.next().toString()));
        contract.setTotalPay(Long.valueOf(iterator.next().toString()));

        return contract;
    }

    public String getContractNumber()
    {
        return this.contractNumber;
    }

    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }

    public String getStartDay()
    {
        return this.startDay;
    }

    public void setStartDay(String startDay)
    {
        this.startDay = startDay;
    }

    public String getEndDay()
    {
        return this.endDay;
    }

    public void setEndDay(String endDay)
    {
        this.endDay = endDay;
    }

    public long getDeposit()
    {
        return this.deposit;
    }

    public void setDeposit(long deposit)
    {
        this.deposit = deposit;
    }

    public long getTotalPay()
    {
        return this.totalPay;
    }

    public void setTotalPay(long totalPay)
    {
        this.totalPay = totalPay;
    }

    @Override
    public String showInformation()
    {
        return "---------Contract Information----------"
                + "\n" + "Contract number: " + this.getContractNumber()
                + "\n" + "Start day: " + this.getStartDay()
                + "\n" + "End day: " + this.getEndDay()
                + "\n" + "Deposit: " + this.getDeposit()
                + "\n" + "Total pay: " + this.getTotalPay();
    }
}
