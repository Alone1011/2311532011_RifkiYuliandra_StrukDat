package UAP_Genap;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class inventorySystem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldIDbarang;
	private JTextField fieldNama;
	private JTextField fieldJumlah;
	private JTextField fieldHarga;
	private JTextField fieldTanggal;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventorySystem frame = new inventorySystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inventorySystem() {
		setTitle("Inventory System\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEM PENDATAAN BARANG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(205, 11, 247, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Barang:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(43, 56, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nama Barang:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(43, 81, 79, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Jumlah:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(43, 106, 79, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Harga Barang:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(43, 131, 79, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Tanggal Pembelian:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_3.setBounds(43, 156, 130, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Kategori:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_4.setBounds(43, 181, 79, 14);
		contentPane.add(lblNewLabel_1_1_4);
		
		fieldIDbarang = new JTextField();
		fieldIDbarang.setBounds(205, 54, 247, 20);
		contentPane.add(fieldIDbarang);
		fieldIDbarang.setColumns(10);
		TextFieldValidator.setDigitOnly(fieldIDbarang, 6);
		
		fieldNama = new JTextField();
		fieldNama.setColumns(10);
		fieldNama.setBounds(205, 79, 247, 20);
		contentPane.add(fieldNama);
		
		fieldJumlah = new JTextField();
		fieldJumlah.setColumns(10);
		fieldJumlah.setBounds(205, 104, 247, 20);
		contentPane.add(fieldJumlah);
		
		fieldHarga = new JTextField();
		fieldHarga.setColumns(10);
		fieldHarga.setBounds(205, 129, 247, 20);
		contentPane.add(fieldHarga);
		
		fieldTanggal = new JTextField();
		fieldTanggal.setColumns(10);
		fieldTanggal.setBounds(205, 154, 247, 20);
		contentPane.add(fieldTanggal);
		
		JComboBox cbKategori = new JComboBox();
		cbKategori.setModel(new DefaultComboBoxModel(new String[] {"Kategori Barang", "Kue", "Sembako", "Makanan Ringan", "Minuman"}));
		cbKategori.setBounds(205, 178, 247, 22);
		contentPane.add(cbKategori);
		
		JButton btnAdd = new JButton("Tambah");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDataToTable();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(497, 53, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDataInTable();
            }
        });
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(496, 89, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Hapus");
		btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDataFromTable();
            }
        });
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(497, 126, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSort = new JButton("Sort\r\n");
		btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortDataInTable();
            }
        });
		btnSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSort.setBounds(496, 162, 89, 23);
		contentPane.add(btnSort);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(43, 226, 542, 228);
		tablePanel.setLayout(new BorderLayout()); 
			contentPane.add(tablePanel);

		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane, BorderLayout.CENTER); 

		table = new JTable();
		tableModel = new DefaultTableModel(
	            new Object[][] {
	            },
	            new String[] {
	                "ID Barang", "Nama Barang", "Jumlah", "Harga Barang", "Tanggal Pembelian"
	            }
	        ) {
	            Class[] columnTypes = new Class[] {
	                String.class, String.class, String.class, String.class, String.class
	            };
	            public Class getColumnClass(int columnIndex) {
	                return columnTypes[columnIndex];
	            }
	        };

	        table.setModel(tableModel);


        table.getColumnModel().getColumn(0).setPreferredWidth(97);
        table.getColumnModel().getColumn(1).setPreferredWidth(97);
        table.getColumnModel().getColumn(2).setPreferredWidth(96);
        table.getColumnModel().getColumn(3).setPreferredWidth(97);
        table.getColumnModel().getColumn(4).setPreferredWidth(106);

        scrollPane.setViewportView(table);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        fieldTanggal.setText(dateFormat.format(currentDate));
    }
	
	private static class TextFieldValidator {
	    public static void setDigitOnly(JTextField textField, int maxLength) {
	        textField.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if (!Character.isDigit(c) || textField.getText().length() >= maxLength) {
	                    e.consume();
	                }
	            }
	        });
	    }
    }

	private void addDataToTable() {
	    String id = fieldIDbarang.getText();
	    if (id.length() > 6) {
	        JOptionPane.showMessageDialog(null, "ID Barang harus 6 digit saja!");
	        return;
	    }
	    String nama = fieldNama.getText();
	    String jumlahStr = fieldJumlah.getText();
	    String hargaStr = fieldHarga.getText();
	    String tanggal = fieldTanggal.getText();

	    if (jumlahStr.isEmpty() || hargaStr.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Jumlah dan Harga harus diisi!");
	        return;
	    }

	    int jumlah = Integer.parseInt(jumlahStr);
	    double harga = Double.parseDouble(hargaStr);

	    tableModel.addRow(new Object[] {id, nama, jumlah, harga, tanggal});

	    fieldIDbarang.setText("");
	    fieldNama.setText("");
	    fieldJumlah.setText("");
	    fieldHarga.setText("");
	    fieldTanggal.setText("");
	}

	private void updateDataInTable() {
	    int row = table.getSelectedRow();
	    if (row!= -1) {
	        String id = fieldIDbarang.getText();
	        if (id.length() > 6) {
	            JOptionPane.showMessageDialog(null, "ID Barang harus 6 digit saja!");
	            return;
	        }
	        String nama = fieldNama.getText();
	        String jumlahStr = fieldJumlah.getText();
	        String hargaStr = fieldHarga.getText();
	        String tanggal = fieldTanggal.getText();

	        if (jumlahStr.isEmpty() || hargaStr.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Jumlah dan Harga harus diisi!");
	            return;
	        }

	        int jumlah = Integer.parseInt(jumlahStr);
	        double harga = Double.parseDouble(hargaStr);

	        tableModel.setValueAt(id, row, 0);
	        tableModel.setValueAt(nama, row, 1);
	        tableModel.setValueAt(jumlah, row, 2);
	        tableModel.setValueAt(harga, row, 3);
	        tableModel.setValueAt(tanggal, row, 4);
	    }
	}

    private void deleteDataFromTable() {
        int row = table.getSelectedRow();
        if (row != -1) {
            tableModel.removeRow(row);
        }
    }

    private void sortDataInTable() {
        int rowCount = tableModel.getRowCount();
        Object[][] data = new Object[rowCount][5];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = tableModel.getValueAt(i, j);
            }
        }

        // Implement Bubble Sort algorithm
        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - i - 1; j++) {
                if (Integer.parseInt((String) data[j][0]) > Integer.parseInt((String) data[j + 1][0])) {
                    // Swap rows
                    Object[] temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        // Update the table model with the sorted data
        tableModel.setRowCount(0);
        for (int i = 0; i < rowCount; i++) {
            tableModel.addRow(data[i]);
        }
    }
}

