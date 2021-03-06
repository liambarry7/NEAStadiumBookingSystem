/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stadiumbookingsystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import library.databaseSQL;
import library.sortsAndSearches;
import objects.event;
import objects.ticket;

/**
 *
 * @author kimia
 */
public class ViewTickets extends javax.swing.JFrame {

    /**
     * Creates new form ViewTickets
     */
    public ViewTickets() {
        initComponents();
        
        fillPurchasedTicketTable();
        sortNextEvent();
        StadiumCreditRefundLabel.setText(0 + " credits");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PurchasedTicketTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        RefundButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StadiumCreditRefundLabel = new javax.swing.JLabel();
        Sorts = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PurchasedTicketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event", "Stand", "Seat", "Age", "Price", "TicketID", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PurchasedTicketTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PurchasedTicketTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PurchasedTicketTable);
        if (PurchasedTicketTable.getColumnModel().getColumnCount() > 0) {
            PurchasedTicketTable.getColumnModel().getColumn(1).setResizable(false);
            PurchasedTicketTable.getColumnModel().getColumn(2).setResizable(false);
            PurchasedTicketTable.getColumnModel().getColumn(3).setResizable(false);
            PurchasedTicketTable.getColumnModel().getColumn(4).setResizable(false);
            PurchasedTicketTable.getColumnModel().getColumn(5).setResizable(false);
            PurchasedTicketTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("TICKETS");

        BackButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        RefundButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RefundButton.setText("Refund Ticket");
        RefundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefundButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Select ticket to view the amount of stadium credit given when refunded. Click 'Refund Ticket' to get a refund after ticket has been selected.");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Stadium Credit refund:");

        StadiumCreditRefundLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        StadiumCreditRefundLabel.setText("jLabel4");

        Sorts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soonest", "Furthest", "A-Z", "Z-A" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Sort:");

        ApplyButton.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BackButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 554, Short.MAX_VALUE)
                                .addComponent(RefundButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(StadiumCreditRefundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(Sorts, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ApplyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sorts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ApplyButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StadiumCreditRefundLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RefundButton)
                    .addComponent(BackButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        AccountMenu am = new AccountMenu();
        am.setSize(616, 540);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void RefundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefundButtonActionPerformed
        try {
            //adding back the refunded ticket to have the correct number of remaining tickets for event
            String eventName = (String) PurchasedTicketTable.getValueAt(PurchasedTicketTable.getSelectedRow(), 0);
            addingBackTicketToEvent(eventName);
            
            int accountID = databaseSQL.getCurrentUser().getAccountID();

            //cast object to integer
            String selectedTicket = (String) PurchasedTicketTable.getValueAt(PurchasedTicketTable.getSelectedRow(), 5);

            int ticketID = Integer.parseInt(selectedTicket);
            databaseSQL.refundTicket(accountID, ticketID);

            //give user stadium credit for refunded ticket
            String refundCredits = StadiumCreditRefundLabel.getText();

            String intValue = refundCredits.replaceAll("[^0-9]", ""); //use regular expression to remove any characters from the string to leave the numbers only
            int ticketRefund = Integer.parseInt(intValue);

            //get current value of stadium credit for account
            int sc = databaseSQL.getCurrentUser().getStadiumCredit();
            int newSC = sc + ticketRefund;

            databaseSQL.updateAccountStadiumCredit(accountID, newSC); //update stadium credit value in database
            databaseSQL.resetCurrentUser(accountID); //refresh current user to have updated attributes
            
            

            //refresh table by closing and reopening window
            ViewTickets vt = new ViewTickets();
            vt.setVisible(true);
            this.dispose();
            
        } catch (Exception e) {
            System.out.println("Error in refunding ticket.");
            System.out.println(e);
        }

    }//GEN-LAST:event_RefundButtonActionPerformed

    private void addingBackTicketToEvent(String eventName) {
        ArrayList<event> eventList = databaseSQL.getEvents();
        
        //search eventList to find matching name
        for (int i = 0; i < eventList.size(); i++) {            
            String event = eventList.get(i).getEventName(); 
            if (eventName.equals(event)) {
                int eventID = eventList.get(i).getEventID();
                //increasing remaining tickets of event by 1 to account for refunded ticket
                int remainingSeats = eventList.get(i).getRemainingTickets() + 1;
                databaseSQL.updateRemainingSeats(eventID, remainingSeats);
            }
        }
        System.out.println("");
    }
    
    private void PurchasedTicketTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchasedTicketTableMouseClicked
        //when ticket is clicked, gui shows the amount of credits they'd get in return for a refund
        String selectedTicket = (String) PurchasedTicketTable.getValueAt(PurchasedTicketTable.getSelectedRow(), 4); //price column
        int ticketPrice = Integer.parseInt(selectedTicket);
        //refund price calculator
        int refundPrice = (ticketPrice / 10) * 2;
        StadiumCreditRefundLabel.setText(Integer.toString(refundPrice) + " credits");
    }//GEN-LAST:event_PurchasedTicketTableMouseClicked

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
         String sortType = Sorts.getSelectedItem().toString();
         
        if (sortType.equalsIgnoreCase("Soonest")) {
            sortNextEvent();
        } else if (sortType.equalsIgnoreCase("Furthest")) {
            sortReverseNextEvent();
        } else if (sortType.equalsIgnoreCase("A-Z")) {
            sortAZ();
        } else if (sortType.equalsIgnoreCase("Z-A")) {
            sortZA();
        }
        
        
    }//GEN-LAST:event_ApplyButtonActionPerformed

    public void sortAZ() {
        int accountID = databaseSQL.getCurrentUser().getAccountID();
        ArrayList<ticket> userTickets = databaseSQL.getUserPurchasedTickets(accountID); //fill array list with tickets user has bought from database
        ArrayList<event> eventsList = databaseSQL.getEvents(); //get list of events
        
        ArrayList<String> ticketNames = new ArrayList<>(); // arraylist used to sort ticket neames into order

        for (int i = 0; i < userTickets.size(); i++) {
            for (int j = 0; j < eventsList.size(); j++) {
                //if ticket id i matches event id, add to ticket names list to be sorted
                if (userTickets.get(i).getEventId() == eventsList.get(j).getEventID()) {
                    ticketNames.add(eventsList.get(j).getEventName());
                }                
            }                   
        }
        
        System.out.println("\nUser's booked tickets before sort:");
        for (int i = 0; i < userTickets.size(); i++) {
            System.out.println(userTickets.get(i));            
        }
        
        //turning name arraylist into array to be sorted
        String[] sortedTicketNames = ticketNames.toArray(new String[0]);
        //sort array into alphabetical order
        library.sortsAndSearches.stringMergeSort(sortedTicketNames);
                
        ArrayList<ticket> ticketAZ = new ArrayList<>();
        
        //where the name of the ticket matches the event name and the ticket's eventId matches the eventID        
        for (int i = 0; i < sortedTicketNames.length; i++) {
            for (int j = 0; j < eventsList.size(); j++) {
                //if ticket name matches event name...
                
                if (sortedTicketNames[i].equals(eventsList.get(j).getEventName())) {
                    
                    //if the ticket id matches the eventID...
                    for (int k = 0; k < userTickets.size(); k++) {
                        if (userTickets.get(k).getEventId() == eventsList.get(j).getEventID()) {
                            
                            if (ticketAZ.size() == 0) {
                                ticketAZ.add(userTickets.get(k));
                            } else if (ticketAZ.contains(userTickets.get(k))) {
                                System.out.print("");
                            } else if (!ticketAZ.contains(userTickets.get(k))) {
                                ticketAZ.add(userTickets.get(k));
                            }

                        }
                        
                    }
                }                
            }            
        }
        
        System.out.println("\nUser's tickets after merge sort in alphabetical order: ");
        for (int i = 0; i < ticketAZ.size(); i++) {
            System.out.println(ticketAZ.get(i));
        }
 
        emptyPurchasedTicketTable(); //removing everyrow from the table
        ArrayList<event> events = databaseSQL.getEvents();

        //updating the table to be in new sorted order
        DefaultTableModel tblModel = (DefaultTableModel) PurchasedTicketTable.getModel();

        //making ticketID and Date column invisible so the user cannot see it, but the program can still retrieve the data
        PurchasedTicketTable.getColumn("TicketID").setMinWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setMaxWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setWidth(0);
        PurchasedTicketTable.getColumn("Date").setMinWidth(0);
        PurchasedTicketTable.getColumn("Date").setMaxWidth(0);
        PurchasedTicketTable.getColumn("Date").setWidth(0);

        //load tickets into the table
        for (int i = 0; i < ticketAZ.size(); i++) {

            //gets event Name from ticket's eventID
            int id = ticketAZ.get(i).getEventId();
            String name = events.get(id - 1).getEventName();
            String date = events.get(id - 1).getEventDate();

            String stand = ticketAZ.get(i).getStand();
            String seat = ticketAZ.get(i).getSeat();
            String age = ticketAZ.get(i).getAge();
            String price = Integer.toString(ticketAZ.get(i).getPrice());
            String ticketID = Integer.toString(ticketAZ.get(i).getTicketID());

            String data[] = {name, stand, seat, age, price, ticketID, date};
            tblModel.addRow(data);
        }
        
    }
    
    public void sortZA() {
        int accountID = databaseSQL.getCurrentUser().getAccountID();
        ArrayList<ticket> userTickets = databaseSQL.getUserPurchasedTickets(accountID); //fill array list with tickets user has bought from database
        ArrayList<event> eventsList = databaseSQL.getEvents(); //get list of events
        
        ArrayList<String> ticketNames = new ArrayList<>(); // arraylist used to sort ticket neames into order

        for (int i = 0; i < userTickets.size(); i++) {
            for (int j = 0; j < eventsList.size(); j++) {

                //if ticket id i matches event id, add to ticket names list to be sorted
                if (userTickets.get(i).getEventId() == eventsList.get(j).getEventID()) {
                    ticketNames.add(eventsList.get(j).getEventName());
                }                
            }                   
        }
        
        System.out.println("\nUser's booked tickets before sort:");
        for (int i = 0; i < userTickets.size(); i++) {
            System.out.println(userTickets.get(i));            
        }
        
        //turning name arraylist into array to be sorted
        String[] sortedTicketNames = ticketNames.toArray(new String[0]);
        
        //sort array into alphabetical order then reverse it using a stack
        library.sortsAndSearches.stringMergeSort(sortedTicketNames);        
        library.sortsAndSearches.stringReverseArray(sortedTicketNames);

        ArrayList<ticket> ticketZA = new ArrayList<>();
        
        //where the name of the ticket matches the event name and the ticket's eventId matches the eventID
        
        for (int i = 0; i < sortedTicketNames.length; i++) {
            for (int j = 0; j < eventsList.size(); j++) {
                //if ticket name matches event name...
                
                if (sortedTicketNames[i].equals(eventsList.get(j).getEventName())) {
                    
                    
                    for (int k = 0; k < userTickets.size(); k++) {
                        if (userTickets.get(k).getEventId() == eventsList.get(j).getEventID()) {
                            
                            if (ticketZA.size() == 0) {
                                ticketZA.add(userTickets.get(k));
                            } else if (ticketZA.contains(userTickets.get(k))) {
                                System.out.print("");
                            } else if (!ticketZA.contains(userTickets.get(k))) {
                                ticketZA.add(userTickets.get(k));
                            }

                        }
                        
                    }
                }                
            }            
        }
        
        System.out.println("\nUser's tickets after merge sort and stack manipulation in reverse alphabetical order: ");
        for (int i = 0; i < ticketZA.size(); i++) {
            System.out.println(ticketZA.get(i));
        }
        

        emptyPurchasedTicketTable(); //removing everyrow from the table
        ArrayList<event> events = databaseSQL.getEvents();

        //updating the table to be in new sorted order
        DefaultTableModel tblModel = (DefaultTableModel) PurchasedTicketTable.getModel();

        //making ticketID and Date column invisible so the user cannot see it, but the program can still retrieve the data
        PurchasedTicketTable.getColumn("TicketID").setMinWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setMaxWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setWidth(0);
        PurchasedTicketTable.getColumn("Date").setMinWidth(0);
        PurchasedTicketTable.getColumn("Date").setMaxWidth(0);
        PurchasedTicketTable.getColumn("Date").setWidth(0);

        //load tickets into the table
        for (int i = 0; i < ticketZA.size(); i++) {

            //gets event Name from ticket's eventID
            int id = ticketZA.get(i).getEventId();
            String name = events.get(id - 1).getEventName();
            String date = events.get(id - 1).getEventDate();

            String stand = ticketZA.get(i).getStand();
            String seat = ticketZA.get(i).getSeat();
            String age = ticketZA.get(i).getAge();
            String price = Integer.toString(ticketZA.get(i).getPrice());
            String ticketID = Integer.toString(ticketZA.get(i).getTicketID());

            String data[] = {name, stand, seat, age, price, ticketID, date};
            tblModel.addRow(data);
        }
    }
    
    public void sortNextEvent() {
        try {
            int tableSize = PurchasedTicketTable.getRowCount();
            String[] stringDateList = new String[tableSize];
            
            //gets ticket dates and adds them to array to be sorted
            for (int i = 0; i < tableSize; i++) {
                stringDateList[i] = (String) PurchasedTicketTable.getValueAt(i, 6);
            }
            
            Date[] dateList = new Date[stringDateList.length];
            
            //turning string date into date onject to be sorted
            for (int i = 0; i < dateList.length; i++) {
                String date = stringDateList[i];
                Date formatDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                dateList[i] = formatDate;
            }
            
            sortsAndSearches.dateBubbleSort(dateList); //sorts date into chronological order
            
            //turns sorted date objects back into strings
            DateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < dateList.length; i++) {
                Date sortedDate = dateList[i];
                String reformattedDate = newFormat.format(sortedDate);
                stringDateList[i] = reformattedDate;
            }
            
            int accountID = databaseSQL.getCurrentUser().getAccountID();
            ArrayList<ticket> userTicketList = databaseSQL.getUserPurchasedTickets(accountID);
            ArrayList<event> eventList = databaseSQL.getEvents();
            ArrayList<ticket> soonestTickets = new ArrayList<>();
            
            System.out.println("\nUser's ticket list before being sorted into chronological order: ");
            for (int i = 0; i < userTicketList.size(); i++) {
                System.out.println(userTicketList.get(i));
            }
            
            for (int i = 0; i < stringDateList.length; i++) {
                for (int j = 0; j < eventList.size(); j++) {

                    String eventDate = eventList.get(j).getEventDate();
                    
                    //if the event date matches the tickets date...
                    if (eventDate.equals(stringDateList[i])) {
                        int eventID = eventList.get(j).getEventID();
                        
                        for (int k = 0; k < userTicketList.size(); k++) {
                            //if the event IDs match, add ticket into sorted list

                            if (userTicketList.get(k).getEventId() == eventID) { 
    
                                if (soonestTickets.size() == 0) {
                                    soonestTickets.add(userTicketList.get(k));
                                } else if (soonestTickets.contains(userTicketList.get(k))) {
                                    System.out.print("");
                                } else if (!soonestTickets.contains(userTicketList.get(k))) {
                                    soonestTickets.add(userTicketList.get(k));
                                }

                            }

                        }

                    }
                    
                }
            }
            
            System.out.println("\nUser's tickets after being sorted into chronological order using a bubble sort: ");
            for (int i = 0; i < soonestTickets.size(); i++) {
                System.out.println(soonestTickets.get(i));
            }

            emptyPurchasedTicketTable(); //removing everyrow from the table
            ArrayList<event> events = databaseSQL.getEvents();

            //updating the table to be in new sorted order
            DefaultTableModel tblModel = (DefaultTableModel) PurchasedTicketTable.getModel();

            //making ticketID and Date column invisible so the user cannot see it, but the program can still retrieve the data
            PurchasedTicketTable.getColumn("TicketID").setMinWidth(0);
            PurchasedTicketTable.getColumn("TicketID").setMaxWidth(0);
            PurchasedTicketTable.getColumn("TicketID").setWidth(0);
            PurchasedTicketTable.getColumn("Date").setMinWidth(0);
            PurchasedTicketTable.getColumn("Date").setMaxWidth(0);
            PurchasedTicketTable.getColumn("Date").setWidth(0);

            //load tickets into the table
            for (int i = 0; i < soonestTickets.size(); i++) {

                //gets event Name from ticket's eventID
                int id = soonestTickets.get(i).getEventId();
                String name = events.get(id - 1).getEventName();
                String date = events.get(id - 1).getEventDate();

                String stand = soonestTickets.get(i).getStand();
                String seat = soonestTickets.get(i).getSeat();
                String age = soonestTickets.get(i).getAge();
                String price = Integer.toString(soonestTickets.get(i).getPrice());
                String ticketID = Integer.toString(soonestTickets.get(i).getTicketID());

                String data[] = {name, stand, seat, age, price, ticketID, date};
                tblModel.addRow(data);
            }

        } catch (Exception e) {
            System.out.println("Error sorting tickets into date order: " + e);
        }
    }
    
    public void sortReverseNextEvent() {
        try {
            int tableSize = PurchasedTicketTable.getRowCount();
            String[] stringDateList = new String[tableSize];

            //gets ticket dates and adds them to array to be sorted
            for (int i = 0; i < tableSize; i++) {
                stringDateList[i] = (String) PurchasedTicketTable.getValueAt(i, 6);
            }

            Date[] dateList = new Date[stringDateList.length];

            //turning string date into date onject to be sorted
            for (int i = 0; i < dateList.length; i++) {
                String date = stringDateList[i];
                Date formatDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                dateList[i] = formatDate;
            }

            sortsAndSearches.dateBubbleSort(dateList); //sorts date into chronological order

            //turns sorted date objects back into strings
            DateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < dateList.length; i++) {
                Date sortedDate = dateList[i];
                String reformattedDate = newFormat.format(sortedDate);
                stringDateList[i] = reformattedDate;
            }

            int accountID = databaseSQL.getCurrentUser().getAccountID();
            ArrayList<ticket> userTicketList = databaseSQL.getUserPurchasedTickets(accountID);
            ArrayList<event> eventList = databaseSQL.getEvents();
            ArrayList<ticket> soonestTickets = new ArrayList<>();
            
            System.out.println("\nUser's ticket list before being sorted into reverse chronological order: ");
            for (int i = 0; i < userTicketList.size(); i++) {
                System.out.println(userTicketList.get(i));
            }

            for (int i = 0; i < stringDateList.length; i++) {
                for (int j = 0; j < eventList.size(); j++) {

                    String eventDate = eventList.get(j).getEventDate();

                    //if the event date matches the tickets date...
                    if (eventDate.equals(stringDateList[i])) {
                        int eventID = eventList.get(j).getEventID();

                        for (int k = 0; k < userTicketList.size(); k++) {
                            //if the event IDs match, add ticket into sorted list
                            if (userTicketList.get(k).getEventId() == eventID) {

                                if (soonestTickets.size() == 0) {
                                    soonestTickets.add(userTicketList.get(k));
                                } else if (soonestTickets.contains(userTicketList.get(k))) {
                                    System.out.print("");
                                } else if (!soonestTickets.contains(userTicketList.get(k))) {
                                    soonestTickets.add(userTicketList.get(k));
                                }
                            }

                        }

                    }

                }
            }

            //converting ArrayList into array to be manipulated
            ticket[] sortedSoonestTickets = soonestTickets.toArray(new ticket[0]);

            sortsAndSearches.ticketReverseArray(sortedSoonestTickets); //using a stack to reverse the array

            //putting tickets into final sorted arraylist 
            ArrayList<ticket> reverseTicketDate = new ArrayList<>();  
            for (int i = 0; i < sortedSoonestTickets.length; i++) {
                reverseTicketDate.add(sortedSoonestTickets[i]);
            }
            
            System.out.println("\nUser's tickets after sorted into reverse chronological order using a bubble sort and a stack: ");
            for (int i = 0; i < reverseTicketDate.size(); i++) {
                System.out.println(reverseTicketDate.get(i));
            }

            emptyPurchasedTicketTable(); //removing everyrow from the table
            ArrayList<event> events = databaseSQL.getEvents();

            //updating the table to be in new sorted order
            DefaultTableModel tblModel = (DefaultTableModel) PurchasedTicketTable.getModel();

            //making ticketID and Date column invisible so the user cannot see it, but the program can still retrieve the data
            PurchasedTicketTable.getColumn("TicketID").setMinWidth(0);
            PurchasedTicketTable.getColumn("TicketID").setMaxWidth(0);
            PurchasedTicketTable.getColumn("TicketID").setWidth(0);
            PurchasedTicketTable.getColumn("Date").setMinWidth(0);
            PurchasedTicketTable.getColumn("Date").setMaxWidth(0);
            PurchasedTicketTable.getColumn("Date").setWidth(0);

            //load tickets into the table
            for (int i = 0; i < reverseTicketDate.size(); i++) {

                //gets event Name from ticket's eventID
                int id = reverseTicketDate.get(i).getEventId();
                String name = events.get(id - 1).getEventName();
                String date = events.get(id - 1).getEventDate();

                String stand = reverseTicketDate.get(i).getStand();
                String seat = reverseTicketDate.get(i).getSeat();
                String age = reverseTicketDate.get(i).getAge();
                String price = Integer.toString(reverseTicketDate.get(i).getPrice());
                String ticketID = Integer.toString(reverseTicketDate.get(i).getTicketID());

                String data[] = {name, stand, seat, age, price, ticketID, date};
                tblModel.addRow(data);
            }

        } catch (Exception e) {
            System.out.println("Error sorting tickets into date order: " + e);
        }

    }
    
    public void emptyPurchasedTicketTable() {
        DefaultTableModel tblModel = (DefaultTableModel)PurchasedTicketTable.getModel();
        tblModel.setRowCount(0);//set rows in table to be 0, making the table empty
    }
    
    
    public void fillPurchasedTicketTable() {
        DefaultTableModel tblModel = (DefaultTableModel)PurchasedTicketTable.getModel();
        
        int accountID = databaseSQL.getCurrentUser().getAccountID();
        ArrayList<ticket> purchasedTicketList = databaseSQL.getUserPurchasedTickets(accountID); //fill array list with tickets user has bought from database
        ArrayList<event> eventsList = databaseSQL.getEvents(); //get list of events
        
        //making ticketID and Date column invisible so the user cannot see it, but the program can still retrieve the data
        PurchasedTicketTable.getColumn("TicketID").setMinWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setMaxWidth(0);
        PurchasedTicketTable.getColumn("TicketID").setWidth(0);
        PurchasedTicketTable.getColumn("Date").setMinWidth(0);
        PurchasedTicketTable.getColumn("Date").setMaxWidth(0);
        PurchasedTicketTable.getColumn("Date").setWidth(0);
        
        
        //load tickets into the table
        for (int i = 0; i < purchasedTicketList.size(); i++) {

            //gets event Name from ticket's eventID
            int id = purchasedTicketList.get(i).getEventId();
            String name = eventsList.get(id - 1).getEventName();
            String date = eventsList.get(id - 1).getEventDate();

            String stand = purchasedTicketList.get(i).getStand();
            String seat = purchasedTicketList.get(i).getSeat();
            String age = purchasedTicketList.get(i).getAge();
            String price = Integer.toString(purchasedTicketList.get(i).getPrice());
            String ticketID = Integer.toString(purchasedTicketList.get(i).getTicketID());

            String data[] = {name, stand, seat, age, price, ticketID, date};
            tblModel.addRow(data);

        }  
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTable PurchasedTicketTable;
    private javax.swing.JButton RefundButton;
    private javax.swing.JComboBox<String> Sorts;
    private javax.swing.JLabel StadiumCreditRefundLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
