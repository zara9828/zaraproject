/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pinjam;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class pinjamServlet extends HttpServlet {

    private String nik;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
    
    Pinjam pjm = new Pinjam();
        Koneksi k = new Koneksi();
        PreparedStatement pst = null;
        int result = 0;
            String aksi = request.getParameter("aksi");
            if (aksi != null) {
                
                switch (aksi) {
                    case "Simpan":
                        pjm.setNo_Transaksi(request.getParameter("no_transaksi"));
                        pjm.setNik(request.getParameter("nik"));
                        pjm.setKd(request.getParameter("kd"));
                        pjm.setJumlah_Pinjam(request.getParameter("jumlah_pinjam"));
                        pjm.setTgl_pinjam(request.getParameter("tgl_pinjam"));
                        pjm.setHarga_pinjam(request.getParameter("harga_pinjam"));
                
                        pst = k.cn.prepareStatement("INSERT INTO tb_transaksi VALUES('"+pjm.getNo_Transaksi()+"','"
                                + pjm.getNo_Transaksi()+ "','"
                                + pjm.getNik() + "','"
                                + pjm.getKd() + "','"
                                + pjm.getJumlah_Pinjam() + "','"
                                + pjm.getTgl_pinjam()+ "','"
                                + pjm.getHarga_pinjam()+ "')");
                        result = pst.executeUpdate();
                        for (int i=1; 1<=2; i++){
                            if (i%2==0){
                                pst=k.cn.prepareStatement("INSERT INTO detailpinjam values('"+pjm.getNo_Transaksi()+""
                                        + pjm.getNik()+"')");
                            } else if (i%2==1){
                                pst=k.cn.prepareStatement("INSERT INTO detailpinjam values('"+pjm.getNo_Transaksi()+""
                                + pjm.getKd()+"')");
                            }
                            result = pst.executeUpdate();
                        if (result > 0) {
                            out.println("<script> "
                                    + "alert('Data berhasil disimpan');"
                                    + "document.location='index.jsp?hal=pinjam';"
                                    + "</script>");
                            }
                        }
                        
                        break;
                    case "Delete":
                        pjm.setNo_Transaksi(request.getParameter(nik));
                        pst = k.cn.prepareStatement("DELETE FROM tb_transaksi WHERE no_transaksi='"
                                + pjm.getNo_Transaksi() + "'");
                        result = pst.executeUpdate();
                        if (result > 0) {
                            out.println("<script> "
                                    + "alert('Data telah dihapus');"
                                    + "document.location='index.jsp?hal=pinjam';"
                                    + "</script>");
                        }
                        break;
                    default:
                }
            } else {
                /* TODO output your page here. You may use following sample code. */
                out.println("<script>");
                out.println("<alert('Gagal Proses')>");
                out.println("document.localtion='index?hal=pinjam'");
                out.println("</script>");
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(pinjamServlet.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(pinjamServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(pinjamServlet.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(pinjamServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
