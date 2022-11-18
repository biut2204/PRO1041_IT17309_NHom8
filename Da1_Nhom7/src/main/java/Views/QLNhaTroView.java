/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.ChuNha;
import Models.DichVu;
import Models.HopDong;
import Models.NguoiThue;
import Models.NhaTro;
import Models.Phong;
import Models.SuCoNhaTro;
import Service.IsvDichVuImpl;
import Service.IsvHopDongImpl;
import Service.IsvNhaTroImpl;
import Service.IsvPhongImpl;
import Service.IsvSuCoNhaTroImpl;
import Service.IsvTienPhongImpl;
import Service.impl.DichVuImpl;
import Service.impl.HopDongImpl;
import Service.impl.NhaTroImpl;
import Service.impl.PhongImpl;
import Service.impl.SuCoNhaTroImpl;
import Service.impl.TienPhongImpl;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MSI
 */
public class QLNhaTroView extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private IsvNhaTroImpl ntR = new NhaTroImpl();
    private IsvPhongImpl pR = new PhongImpl();
    private IsvSuCoNhaTroImpl scntR = new SuCoNhaTroImpl();
    private IsvDichVuImpl dvR = new DichVuImpl();
    private IsvHopDongImpl hdR = new HopDongImpl();
    private IsvTienPhongImpl tpR = new TienPhongImpl();

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Creates new form QLNhaTro
     */
    public QLNhaTroView() {
        initComponents();
        String ten = "P101";
        LoadNhaTro(ntR.getAllData());
        LoadTaoPhong(pR.getAllData());
        LoadThongTinPhong(pR.getAllData());
        LoadSuCoNhaTro(scntR.getAllData());
        LoadDichVu(dvR.getAllData());
        LoadHopDong(hdR.getAllData());

        Icon icon10 = new ImageIcon("obama.PNG");
        this.lbl_anh.setIcon(icon10);
        //share(ten);
        del();
    }

//    private void share(String ten){
//        DefaultTableModel dmt = (DefaultTableModel) tb_thongtinphong.getModel();
//        String search = ten;
//        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
//        tb_thongtinphong.setRowSorter(tr);
//        tr.setRowFilter(RowFilter.regexFilter(search));
//    }
    public void LoadNhaTro(List<NhaTro> list) {
        dtm = (DefaultTableModel) tb_bangnhatro.getModel();
        dtm.setRowCount(0);
        for (NhaTro nhaTro : list) {
            dtm.addRow(new Object[]{
                nhaTro.getChuNha().getHoTen(), nhaTro.getTenNha(), nhaTro.getDiaChi()
            });
        }
    }

    private void LoadTaoPhong(List<Phong> list) {
        dtm = (DefaultTableModel) tb_bangtaophong.getModel();
        dtm.setRowCount(0);
        for (Phong phong : list) {
            dtm.addRow(new Object[]{
                phong.getMa(), phong.getNhaTro().getTenNha(), phong.getNguoiThue().getHoTen(),
                phong.getTenPhong(), phong.getGiaPhong(), phong.getDienTich(), phong.getHinhAnhHopDong()});
        }
    }

    private void LoadThongTinPhong(List<Phong> list) {
        dtm = (DefaultTableModel) tb_thongtinphong.getModel();
        dtm.setRowCount(0);
        for (Phong phong : list) {
            dtm.addRow(new Object[]{
                phong.getTenPhong(), phong.getDienTich(), phong.getGiaPhong(), phong.getTinhTrang(), phong.getSoNguoiHienCo()});
        }
    }

    private void LoadSuCoNhaTro(List<SuCoNhaTro> list) {
        dtm = (DefaultTableModel) tb_bangsuconhatro.getModel();
        dtm.setRowCount(0);
        for (SuCoNhaTro scnt : list) {
            dtm.addRow(new Object[]{
                scnt.getTenSuCo(), scnt.getThoiGianThongBao(), scnt.getMoTa(), scnt.getTrangThai(),
                scnt.getNhaTro().getTenNha(), scnt.getChuNha().getHoTen(), scnt.getMa()});
        }
    }

    private void LoadDichVu(List<DichVu> list) {
        dtm = (DefaultTableModel) tb_bangdichvu.getModel();
        dtm.setRowCount(0);
        for (DichVu dv : list) {
            dtm.addRow(new Object[]{
                dv.getTenDichVu(), dv.getDonGia()});
        }
    }

    private void LoadHopDong(List<HopDong> list) {
        dtm = (DefaultTableModel) tb_banghopdong.getModel();
        dtm.setRowCount(0);
        for (HopDong hd : list) {
            dtm.addRow(new Object[]{
                hd.getChuNha().getHoTen(), hd.getNguoiThue().getHoTen(), hd.getPhong().getTenPhong(),
                hd.getNgayBatDau(), hd.getNgayHetHan(), hd.getNgaySua(), hd.getTrangThai(), hd.getMa()});
        }
    }

    private void del() {
        txt_maphong.setEditable(false);
        txt_thongtintenphong.setEditable(false);
        txt_thongtinsoxe.setEditable(false);
        txt_thongtindientich.setEditable(false);
        txt_thongtingiatien.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_chunha = new javax.swing.JTextField();
        txt_tennhatro = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bangnhatro = new javax.swing.JTable();
        btn_suant = new javax.swing.JButton();
        btn_clearnt = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_maphong = new javax.swing.JTextField();
        txt_tenphong = new javax.swing.JTextField();
        txt_giaphong = new javax.swing.JTextField();
        txt_nhatro = new javax.swing.JTextField();
        txt_nguoithue = new javax.swing.JTextField();
        txt_dientich = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_bangtaophong = new javax.swing.JTable();
        btn_themphong = new javax.swing.JButton();
        btn_suaphong = new javax.swing.JButton();
        btn_clearphong = new javax.swing.JButton();
        lbl_anh = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_thongtintenphong = new javax.swing.JTextField();
        txt_thongtinsonguoi = new javax.swing.JTextField();
        txt_thongtinsoxe = new javax.swing.JTextField();
        txt_thongtintinhtrang = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_thongtindientich = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_thongtingiatien = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_thongtinphong = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_tensuco = new javax.swing.JTextField();
        txt_motasuco = new javax.swing.JTextField();
        txt_thoigianthongbao = new javax.swing.JTextField();
        txt_trangthaisuco = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_bangsuconhatro = new javax.swing.JTable();
        btn_thongbao = new javax.swing.JButton();
        btn_suachuaxong = new javax.swing.JButton();
        btn_clearsuco = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_tendichvu = new javax.swing.JTextField();
        txt_dongiadichvu = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_bangdichvu = new javax.swing.JTable();
        btn_themdichvu = new javax.swing.JButton();
        btn_updatedichvu = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_chunhahopdong = new javax.swing.JTextField();
        txt_nguoithuehopdong = new javax.swing.JTextField();
        txt_phonghopdong = new javax.swing.JTextField();
        txt_trangthaihopdong = new javax.swing.JTextField();
        txt_ngaybatdauhopdong = new javax.swing.JTextField();
        txt_ngayhethanhopdong = new javax.swing.JTextField();
        txt_ngaysuahopdong = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_noidunghopdong = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_banghopdong = new javax.swing.JTable();
        btn_themhopdong = new javax.swing.JButton();
        btn_suahopdong = new javax.swing.JButton();
        btn_clearhopdong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Chu nha :");

        jLabel1.setText("Ten nha tro :");

        jLabel3.setText("Dia chi :");

        txt_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diachiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_chunha)
                    .addComponent(txt_tennhatro)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_chunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tennhatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tb_bangnhatro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Chu nha", "Ten nha tro", "Dia chi"
            }
        ));
        tb_bangnhatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangnhatroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bangnhatro);

        btn_suant.setText("Sua");
        btn_suant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suantActionPerformed(evt);
            }
        });

        btn_clearnt.setText("Clear");
        btn_clearnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btn_suant)
                        .addGap(125, 125, 125)
                        .addComponent(btn_clearnt)))
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suant)
                    .addComponent(btn_clearnt))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nha tro", jPanel5);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Ma :");

        jLabel5.setText("Nha Tro :");

        jLabel6.setText("Nguoi thue :");

        jLabel7.setText("Ten phong :");

        jLabel8.setText("Gia phong :");

        jLabel9.setText("Dien tich :");

        txt_giaphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaphongActionPerformed(evt);
            }
        });

        txt_nguoithue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nguoithueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_maphong)
                    .addComponent(txt_tenphong)
                    .addComponent(txt_giaphong, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nhatro)
                    .addComponent(txt_nguoithue)
                    .addComponent(txt_dientich, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nhatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txt_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nguoithue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txt_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dientich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        tb_bangtaophong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Nha tro", "Nguoi thue", "Ten phong", "Gia phong", "Dien tich", "Hinh anh hop dong"
            }
        ));
        tb_bangtaophong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangtaophongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_bangtaophong);

        btn_themphong.setText("Them");
        btn_themphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themphongActionPerformed(evt);
            }
        });

        btn_suaphong.setText("Sua");
        btn_suaphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaphongActionPerformed(evt);
            }
        });

        btn_clearphong.setText("Clear");
        btn_clearphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearphongActionPerformed(evt);
            }
        });

        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btn_themphong)
                        .addGap(105, 105, 105)
                        .addComponent(btn_suaphong)
                        .addGap(87, 87, 87)
                        .addComponent(btn_clearphong))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themphong)
                    .addComponent(btn_suaphong)
                    .addComponent(btn_clearphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane2.addTab("Phong", jPanel6);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Ten phong :");

        jLabel11.setText("So xe :");

        jLabel12.setText("So nguoi hien co :");

        jLabel13.setText("Tinh trang :");

        jLabel14.setText("Dien tich :");

        jLabel15.setText("Gia tien :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_thongtintenphong)
                    .addComponent(txt_thongtinsoxe)
                    .addComponent(txt_thongtingiatien, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_thongtinsonguoi)
                    .addComponent(txt_thongtintinhtrang)
                    .addComponent(txt_thongtindientich))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(txt_thongtintenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thongtinsonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_thongtinsoxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_thongtindientich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_thongtintinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_thongtingiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        tb_thongtinphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên phòng", "Dien tich", "Gia tien", "Tinh trang", "So nguoi"
            }
        ));
        tb_thongtinphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_thongtinphongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_thongtinphong);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btn_update)
                        .addGap(126, 126, 126)
                        .addComponent(btn_clear))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update)
                    .addComponent(btn_clear))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thong tin phong", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Ten su co :");

        jLabel17.setText("Thoi gian thong bao :");

        jLabel18.setText("Mo ta :");

        jLabel19.setText("Trang thai :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tensuco)
                    .addComponent(txt_motasuco, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_trangthaisuco))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_thoigianthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txt_tensuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thoigianthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(txt_motasuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangthaisuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tb_bangsuconhatro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ten su co", "Thoi gian thong bao", "Mo ta", "Trang thai"
            }
        ));
        tb_bangsuconhatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangsuconhatroMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_bangsuconhatro);

        btn_thongbao.setText("Thong bao");
        btn_thongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongbaoActionPerformed(evt);
            }
        });

        btn_suachuaxong.setText("Sua chua xong");
        btn_suachuaxong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suachuaxongActionPerformed(evt);
            }
        });

        btn_clearsuco.setText("Clear");
        btn_clearsuco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearsucoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btn_thongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btn_suachuaxong)
                        .addGap(73, 73, 73)
                        .addComponent(btn_clearsuco, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thongbao)
                    .addComponent(btn_suachuaxong)
                    .addComponent(btn_clearsuco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane2.addTab("Su co nha tro", jPanel8);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Ten dich vu :");

        jLabel21.setText("Don gia :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_tendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(txt_tendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tb_bangdichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ten dich vu", "Don gia"
            }
        ));
        jScrollPane5.setViewportView(tb_bangdichvu);

        btn_themdichvu.setText("Them");
        btn_themdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themdichvuActionPerformed(evt);
            }
        });

        btn_updatedichvu.setText("Update");

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btn_themdichvu)
                        .addGap(130, 130, 130)
                        .addComponent(btn_updatedichvu)
                        .addGap(131, 131, 131)
                        .addComponent(jButton6)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themdichvu)
                    .addComponent(btn_updatedichvu)
                    .addComponent(jButton6))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dich vu", jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Chu nha :");

        jLabel23.setText("Nguoi thue :");

        jLabel24.setText("Phong ;");

        jLabel25.setText("Ngay bat dau :");

        jLabel26.setText("Ngay het han :");

        jLabel27.setText("Ngay sua :");

        jLabel28.setText("Trang thai :");

        jLabel29.setText("Noi dung :");

        txt_noidunghopdong.setColumns(20);
        txt_noidunghopdong.setRows(5);
        jScrollPane6.setViewportView(txt_noidunghopdong);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_chunhahopdong)
                    .addComponent(txt_nguoithuehopdong)
                    .addComponent(txt_phonghopdong)
                    .addComponent(txt_trangthaihopdong, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ngaybatdauhopdong)
                    .addComponent(txt_ngayhethanhopdong)
                    .addComponent(txt_ngaysuahopdong)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(txt_chunhahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaybatdauhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(txt_nguoithuehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayhethanhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27)
                    .addComponent(txt_phonghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaysuahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel29)
                        .addComponent(txt_trangthaihopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tb_banghopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Chu nha", "Nguoi thue", "Phong", "Ngay bat dau", "Ngay het han", "Ngay sua", "Noi dung", "trang thai"
            }
        ));
        jScrollPane7.setViewportView(tb_banghopdong);

        btn_themhopdong.setText("Them");
        btn_themhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themhopdongActionPerformed(evt);
            }
        });

        btn_suahopdong.setText("Sua");
        btn_suahopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suahopdongActionPerformed(evt);
            }
        });

        btn_clearhopdong.setText("Clear");
        btn_clearhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearhopdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btn_themhopdong)
                        .addGap(155, 155, 155)
                        .addComponent(btn_suahopdong)
                        .addGap(157, 157, 157)
                        .addComponent(btn_clearhopdong))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themhopdong)
                    .addComponent(btn_suahopdong)
                    .addComponent(btn_clearhopdong))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Hop Dong", jPanel11);

        jDesktopPane1.setLayer(jTabbedPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diachiActionPerformed

    private void btn_suantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suantActionPerformed
        // TODO add your handling code here:
        int index = tb_bangnhatro.getSelectedRow();
        NhaTro nhatro = ntR.getAllData().get(index);
        ChuNha chunha = new ChuNha();

        String ten = txt_chunha.getText().trim();
        String tennha = txt_tennhatro.getText().trim();
        String diachi = txt_diachi.getText().trim();

        UUID idcn = ntR.findByIdCN(ten);
        chunha.setId(idcn);

        nhatro.setChuNha(chunha);
        nhatro.setTenNha(tennha);
        nhatro.setDiaChi(diachi);
        ntR.update(nhatro);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadNhaTro(ntR.getAllData());
    }//GEN-LAST:event_btn_suantActionPerformed

    private void tb_bangnhatroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangnhatroMouseClicked
        // TODO add your handling code here:
        int index = tb_bangnhatro.getSelectedRow();
        NhaTro nhatro = ntR.getAllData().get(index);
        txt_chunha.setText(nhatro.getChuNha().getHoTen());
        txt_tennhatro.setText(nhatro.getTenNha());
        txt_diachi.setText(nhatro.getDiaChi());
    }//GEN-LAST:event_tb_bangnhatroMouseClicked

    private void btn_clearntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearntActionPerformed
        // TODO add your handling code here:
        txt_chunha.setText("");
        txt_diachi.setText("");
        txt_tennhatro.setText("");
    }//GEN-LAST:event_btn_clearntActionPerformed

    private void txt_giaphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaphongActionPerformed

    private void txt_nguoithueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nguoithueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nguoithueActionPerformed

    String hinh = null;

    private void btn_themphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themphongActionPerformed
        // TODO add your handling code here:
        Phong phong = new Phong();
        NhaTro nhatro = new NhaTro();
        NguoiThue nguoithue = new NguoiThue();

        int index = tb_bangtaophong.getRowCount() + 1;
        String ma = "Ma" + String.valueOf(index);
        String tennha = txt_nhatro.getText().trim();
        String tennguoithue = txt_nguoithue.getText().trim();
        String tenphong = txt_tenphong.getText().trim();
        int giaphong = Integer.parseInt(txt_giaphong.getText().trim());
        Float dientich = Float.valueOf(txt_dientich.getText());

        UUID idnha = pR.findByIdNhaTro(tennha);
        nhatro.setId(idnha);

        UUID idnt = pR.findByIdNT(tennguoithue);
        nguoithue.setId(idnt);
        if (pR.findSoNguoiHienCo(tenphong) >= 1) {
            JOptionPane.showMessageDialog(this, "da co nguoi thue");
        } else {
            phong.setMa(ma);
            phong.setNhaTro(nhatro);
            phong.setNguoiThue(nguoithue);
            phong.setTenPhong(tenphong);
            phong.setGiaPhong(giaphong);
            phong.setDienTich(dientich);
            phong.setHinhAnhHopDong(hinh);
            pR.save(phong);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadTaoPhong(pR.getAllData());
        }
    }//GEN-LAST:event_btn_themphongActionPerformed

    private void btn_suaphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaphongActionPerformed
        // TODO add your handling code here:
        int index = tb_bangtaophong.getSelectedRow();
        Phong phong = pR.getAllData().get(index);
        NhaTro nhatro = new NhaTro();
        NguoiThue nguoithue = new NguoiThue();

        String ma = txt_maphong.getText().trim();
        String tennha = txt_nhatro.getText().trim();
        String tennguoithue = txt_nguoithue.getText().trim();
        String tenphong = txt_tenphong.getText().trim();
        int giaphong = Integer.parseInt(txt_giaphong.getText().trim());
        Float dientich = Float.valueOf(txt_dientich.getText());

        UUID idnha = pR.findByIdNhaTro(tennha);
        nhatro.setId(idnha);

        UUID idnt = pR.findByIdNT(tennguoithue);
        nguoithue.setId(idnt);

        int nguoivao = 1;
        int xevao = 1;
        phong.setMa(ma);
        phong.setNhaTro(nhatro);
        phong.setNguoiThue(nguoithue);
        phong.setTenPhong(tenphong);
        phong.setGiaPhong(giaphong);
        phong.setDienTich(dientich);
        phong.setSoNguoiHienCo(nguoivao);
        phong.setSoXe(xevao);
        phong.setHinhAnhHopDong(hinh);
        pR.update(phong);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadTaoPhong(pR.getAllData());
    }//GEN-LAST:event_btn_suaphongActionPerformed

    public void fillSinhVienLenForm(Phong sv) {
        txt_maphong.setText(sv.getMa());
        txt_nhatro.setText(sv.getNhaTro().getTenNha());
        txt_nguoithue.setText(sv.getNguoiThue().getHoTen());
        txt_tenphong.setText(sv.getTenPhong());
        txt_giaphong.setText(String.valueOf(sv.getGiaPhong()));
        txt_dientich.setText(String.valueOf(sv.getDienTich()));
        ImageIcon imgIcon = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getHinhAnhHopDong());
        Image img = imgIcon.getImage();
        lbl_anh.setIcon(new ImageIcon(img.getScaledInstance(lbl_anh.getWidth(), lbl_anh.getHeight(), 0)));
    }

    public Phong show(String maSV) {
        for (Phong sv : pR.getAllData()) {
            if (sv.getMa().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }

    private void tb_bangtaophongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangtaophongMouseClicked
        // TODO add your handling code here:
        int id = tb_bangtaophong.rowAtPoint(evt.getPoint());
        String masv = tb_bangtaophong.getValueAt(id, 0).toString();
        Phong sv = show(masv);
        fillSinhVienLenForm(sv);
    }//GEN-LAST:event_tb_bangtaophongMouseClicked

    private void btn_clearphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearphongActionPerformed
        // TODO add your handling code here:
        txt_maphong.setText("");
        txt_nhatro.setText("");
        txt_tenphong.setText("");
        txt_nguoithue.setText("");
        txt_giaphong.setText("");
        txt_dientich.setText("");
    }//GEN-LAST:event_btn_clearphongActionPerformed

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinh = file.getName();
            lbl_anh.setText("");
            int width = lbl_anh.getWidth();
            int height = lbl_anh.getHeight();
            lbl_anh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void tb_thongtinphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_thongtinphongMouseClicked
        // TODO add your handling code here:
        int index = tb_thongtinphong.getSelectedRow();
        Phong p = pR.getAllData().get(index);
        String xe = "Co";
        txt_thongtintenphong.setText(p.getTenPhong());
        txt_thongtinsonguoi.setText(String.valueOf(p.getSoNguoiHienCo()));
        txt_thongtinsoxe.setText(String.valueOf(pR.findSoXeHienCo(p.getTenPhong(), xe)));
        txt_thongtindientich.setText(String.valueOf(p.getDienTich()));
        txt_thongtingiatien.setText(String.valueOf(p.getGiaPhong()));
        txt_thongtintinhtrang.setText(p.getTinhTrang());
    }//GEN-LAST:event_tb_thongtinphongMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int index = tb_thongtinphong.getSelectedRow();
        Phong phong = pR.getAllData().get(index);
        String tinhtrang = txt_thongtintinhtrang.getText().trim();
        int songuoi = Integer.parseInt(txt_thongtinsonguoi.getText().trim());
        
        phong.setSoNguoiHienCo(songuoi);
        phong.setTinhTrang(tinhtrang);
        pR.update(phong);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadThongTinPhong(pR.getAllData());
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_thongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongbaoActionPerformed
        try {
            // TODO add your handling code here:
            SuCoNhaTro scnt = new SuCoNhaTro();
            NhaTro nt = new NhaTro();
            ChuNha cn = new ChuNha();

            int index = tb_bangsuconhatro.getRowCount() + 1;
            String ma = "SuCo" + String.valueOf(index);
            String ten = txt_tensuco.getText().trim();
            Date ngay = sdf.parse(txt_thoigianthongbao.getText().trim());
            String mota = txt_motasuco.getText().trim();
            String trangthai = "đang sửa";

            String tennha = "Nhom 7";
            String tenchunha = "admin";

            UUID idnha = pR.findByIdNhaTro(tennha);
            nt.setId(idnha);

            UUID idchunha = ntR.findByIdCN(tenchunha);
            cn.setId(idchunha);

            scnt.setTenSuCo(ten);
            scnt.setThoiGianThongBao(ngay);
            scnt.setMoTa(mota);
            scnt.setTrangThai(trangthai);
            scnt.setNhaTro(nt);
            scnt.setChuNha(cn);
            scnt.setMa(ma);
            scntR.save(scnt);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadSuCoNhaTro(scntR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(QLNhaTroView.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_thongbaoActionPerformed

    private void btn_suachuaxongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suachuaxongActionPerformed
        // TODO add your handling code here:
        int index = tb_bangsuconhatro.getSelectedRow();
        SuCoNhaTro scnt = scntR.getAllData().get(index);
        String trangthai = "sửa xong";
        scnt.setTrangThai(trangthai);
        scntR.update(scnt);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadSuCoNhaTro(scntR.getAllData());
    }//GEN-LAST:event_btn_suachuaxongActionPerformed

    private void tb_bangsuconhatroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangsuconhatroMouseClicked
        // TODO add your handling code here:
        int index = tb_bangsuconhatro.getSelectedRow();
        SuCoNhaTro scnt = scntR.getAllData().get(index);
        txt_tensuco.setText(scnt.getTenSuCo());
        txt_thoigianthongbao.setText(String.valueOf(scnt.getThoiGianThongBao()));
        txt_motasuco.setText(scnt.getMoTa());
        txt_trangthaisuco.setText(scnt.getTrangThai());
    }//GEN-LAST:event_tb_bangsuconhatroMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        txt_thongtintenphong.setText("");
        txt_thongtinsonguoi.setText("");
        txt_thongtinsoxe.setText("");
        txt_thongtingiatien.setText("");
        txt_thongtindientich.setText("");
        txt_thongtintinhtrang.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_clearsucoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearsucoActionPerformed
        // TODO add your handling code here:
        txt_tensuco.setText("");
        txt_thoigianthongbao.setText("");
        txt_motasuco.setText("");
        txt_trangthaisuco.setText("");
    }//GEN-LAST:event_btn_clearsucoActionPerformed

    private void btn_themdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdichvuActionPerformed
        // TODO add your handling code here:
        DichVu dv = new DichVu();
        NhaTro nt = new NhaTro();

        String ten = txt_tendichvu.getText().trim();
        int dongia = Integer.parseInt(txt_dongiadichvu.getText().trim());
        String tennha = "Nhom 7";
        int index = tb_bangdichvu.getRowCount() + 1;
        String ma = "DichVu" + String.valueOf(index);

        UUID idnha = pR.findByIdNhaTro(tennha);
        nt.setId(idnha);

        dv.setTenDichVu(ten);
        dv.setDonGia(dongia);
        dv.setMa(ma);
        dv.setNhaTro(nt);
        dvR.save(dv);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadDichVu(dvR.getAllData());
    }//GEN-LAST:event_btn_themdichvuActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        txt_tendichvu.setText("");
        txt_dongiadichvu.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_themhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themhopdongActionPerformed
        try {
            // TODO add your handling code here:
            HopDong hd = new HopDong();
            ChuNha cn = new ChuNha();
            NguoiThue nt = new NguoiThue();
            Phong p = new Phong();

            int index = tb_banghopdong.getRowCount() + 1;
            String ma = "HopDong" + String.valueOf(index);
            String tencn = txt_chunhahopdong.getText().trim();
            String tennt = txt_nguoithuehopdong.getText().trim();
            String tenp = txt_phonghopdong.getText().trim();
            Date ngaybatdau = sdf.parse(txt_ngaybatdauhopdong.getText().trim());
            Date ngayhethan = sdf.parse(txt_ngayhethanhopdong.getText().trim());
            Date ngaysua = java.util.Calendar.getInstance().getTime();
            String noidung = txt_noidunghopdong.getText().trim();
            String trangthai = txt_trangthaihopdong.getText().trim();

            UUID idcn = ntR.findByIdCN(tencn);
            cn.setId(idcn);

            UUID idp = tpR.findByIdPhong(tenp);
            p.setId(idp);

            UUID idnt = pR.findByIdNT(tennt);
            nt.setId(idnt);

            hd.setMa(ma);
            hd.setNguoiThue(nt);
            hd.setChuNha(cn);
            hd.setPhong(p);
            hd.setNgayBatDau(ngaybatdau);
            hd.setNgayHetHan(ngayhethan);
            hd.setNgaySua(ngaysua);
            hd.setNoiDung(noidung);
            hd.setTrangThai(trangthai);
            hdR.save(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadHopDong(hdR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(QLNhaTroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_themhopdongActionPerformed

    private void btn_suahopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suahopdongActionPerformed
        try {
            // TODO add your handling code here:
            int index = tb_banghopdong.getSelectedRow();
            HopDong hd = hdR.getAllData().get(index);
            ChuNha cn = new ChuNha();
            NguoiThue nt = new NguoiThue();
            Phong p = new Phong();

            String tencn = txt_chunha.getText().trim();
            String tennt = txt_nguoithuehopdong.getText().trim();
            String tenp = txt_phonghopdong.getText().trim();
            Date ngaybatdau = sdf.parse(txt_ngaybatdauhopdong.getText().trim());
            Date ngayhethan = sdf.parse(txt_ngayhethanhopdong.getText().trim());
            Date ngaysua = java.util.Calendar.getInstance().getTime();
            String noidung = txt_noidunghopdong.getText().trim();
            String trangthai = txt_trangthaihopdong.getText().trim();

            UUID idcn = ntR.findByIdCN(tencn);
            cn.setId(idcn);

            UUID idp = tpR.findByIdPhong(tenp);
            p.setId(idp);

            UUID idnt = pR.findByIdNT(tennt);
            nt.setId(idnt);

            hd.setNguoiThue(nt);
            hd.setChuNha(cn);
            hd.setPhong(p);
            hd.setNgayBatDau(ngaybatdau);
            hd.setNgayHetHan(ngayhethan);
            hd.setNgaySua(ngaysua);
            hd.setNoiDung(noidung);
            hd.setTrangThai(trangthai);
            hdR.update(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadHopDong(hdR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(QLNhaTroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suahopdongActionPerformed

    private void btn_clearhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearhopdongActionPerformed
        // TODO add your handling code here:
        txt_chunhahopdong.setText("");
        txt_nguoithuehopdong.setText("");
        txt_phonghopdong.setText("");
        txt_ngaybatdauhopdong.setText("");
        txt_ngayhethanhopdong.setText("");
        txt_ngaysuahopdong.setText("");
        txt_noidunghopdong.setText("");
        txt_trangthaihopdong.setText("");
    }//GEN-LAST:event_btn_clearhopdongActionPerformed

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
            java.util.logging.Logger.getLogger(QLNhaTroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhaTroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhaTroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhaTroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhaTroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clearhopdong;
    private javax.swing.JButton btn_clearnt;
    private javax.swing.JButton btn_clearphong;
    private javax.swing.JButton btn_clearsuco;
    private javax.swing.JButton btn_suachuaxong;
    private javax.swing.JButton btn_suahopdong;
    private javax.swing.JButton btn_suant;
    private javax.swing.JButton btn_suaphong;
    private javax.swing.JButton btn_themdichvu;
    private javax.swing.JButton btn_themhopdong;
    private javax.swing.JButton btn_themphong;
    private javax.swing.JButton btn_thongbao;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_updatedichvu;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JTable tb_bangdichvu;
    private javax.swing.JTable tb_banghopdong;
    private javax.swing.JTable tb_bangnhatro;
    private javax.swing.JTable tb_bangsuconhatro;
    private javax.swing.JTable tb_bangtaophong;
    private javax.swing.JTable tb_thongtinphong;
    private javax.swing.JTextField txt_chunha;
    private javax.swing.JTextField txt_chunhahopdong;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_dientich;
    private javax.swing.JTextField txt_dongiadichvu;
    private javax.swing.JTextField txt_giaphong;
    private javax.swing.JTextField txt_maphong;
    private javax.swing.JTextField txt_motasuco;
    private javax.swing.JTextField txt_ngaybatdauhopdong;
    private javax.swing.JTextField txt_ngayhethanhopdong;
    private javax.swing.JTextField txt_ngaysuahopdong;
    private javax.swing.JTextField txt_nguoithue;
    private javax.swing.JTextField txt_nguoithuehopdong;
    private javax.swing.JTextField txt_nhatro;
    private javax.swing.JTextArea txt_noidunghopdong;
    private javax.swing.JTextField txt_phonghopdong;
    private javax.swing.JTextField txt_tendichvu;
    private javax.swing.JTextField txt_tennhatro;
    private javax.swing.JTextField txt_tenphong;
    private javax.swing.JTextField txt_tensuco;
    private javax.swing.JTextField txt_thoigianthongbao;
    private javax.swing.JTextField txt_thongtindientich;
    private javax.swing.JTextField txt_thongtingiatien;
    private javax.swing.JTextField txt_thongtinsonguoi;
    private javax.swing.JTextField txt_thongtinsoxe;
    private javax.swing.JTextField txt_thongtintenphong;
    private javax.swing.JTextField txt_thongtintinhtrang;
    private javax.swing.JTextField txt_trangthaihopdong;
    private javax.swing.JTextField txt_trangthaisuco;
    // End of variables declaration//GEN-END:variables
}
