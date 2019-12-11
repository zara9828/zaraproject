<%-- 
    Document   : pinjam
    Created on : Dec 8, 2019, 4:04:39 PM
    Author     : USER
--%>
<%@page import="java.sql.*"%>
<%@page import="control.Koneksi"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.Film"%>
<%@page import="model.Pelanggan"%>
<%@page import="model.Pinjam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Pinjam pjm = new Pinjam();
    Film film = new Film();
    Pelanggan plgn = new Pelanggan();
    Koneksi k = new Koneksi();
    ResultSet rs = null;
    ResultSet qryfilm = null;
    ResultSet qryplgn = null;
    ResultSet qrypjm = null;
    %>
    <h1> pinjaman </h1>
    <form action="pinjamServlet" method="post">
        <table border="0">
            <tr>
                <td>No. Transaksi</td>
                <td>:</td>
                <td>
                    <%
                       try {
                           ResultSet not = null;
                           not = k.st.executeQuery("Select max(right(no_transaksi,8)) as no_transaksi FROM tb_peminjaman");
                           while (not.next()) {
                               if(not.first() == false) {
                                   out.println("<input type='hidden' name='no_transaksi' value='PJ00000001'/>");
                                   out.println("<input type='text' disabled='disabled' value='PJ00000001'/>");
                               } else {
                                   not.last();
                                   int autonot = not.getInt(1) + 1;
                                   String nomert = String.valueOf(autonot);
                                   int noLong = nomert.length();
                                   
                                   for (int a = 1; a< 9 - noLong; a++){
                                     nomert = "0" + nomert;  
                                   }
                                   String nomort = "tr" + nomert;
                                   out.println("<input type='hidden' name='no_transaksi' value'" + nomert + "'/>");
                                   out.println("<input type='hidden' disabled='disabled' value'" + nomert + "'/>");
                               }
                           }
                       } catch (Exception e){
                           out.println(e);
                       }
                    %>
                </td>
            </tr>
            <tr>
                <td>NIK</td>
                <td>:</td>
                <td>
                    <select name='nik'>
                        <%
                            qryplgn = k.st.executeQuery("SELECT nik"
                                    + "FROM tb_pelanggan "
                                    + "WHERE left(nik,2) =11");
                            while (qryplgn.next()){
                                pjm.setNik(qryplgn.getString("nik"));
                        %>
                        <option value"<%=pjm.getNik()%>"><%=pjm.getNik()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Kode film</td>
                <td>:</td>
                <td>
                    <td>
                    <select name='kd'>
                        <%
                            qryfilm = k.st.executeQuery("SELECT kd"
                                    + "FROM tb_film "
                                    + "WHERE left(film,2) =11");
                            while (qryfilm.next()){
                                pjm.setKd(qryfilm.getString("kd"));
                        %>
                        <option value"<%=pjm.getKd()%>"><%=pjm.getKd()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Jumlah pinjam</td>
                <td>:</td>
                <td><input type="text" name="jumlah_pinjam"></td>
            </tr>
            <tr>
                <td>Tanggal pinjam</td>
                <td>:</td>
                <td><input type="date" name="tgl_pinjam"/></td>
            </tr>
            <tr>
                <td>Harga pinjam</td>
                <td>:</td>
                <td align="center" colspan="3"><input type="submit" name="aksi" value="insert" class="button"</td>
            </tr>
        </table>
    </form>
<br>

<table border="0" cellpadding="0" cellspacing="0">
    <%
        rs = k.st.executeQuery("SELECT *from tb_peminjaman");
        while (rs.next()){
            out.println("<tr class=isi>"
                    +"<td><a href=index.jsp?hal=detailpinjam&no_transaksi=" + rs.getString(1) + " target='_blank'>"+ rs.getString(1) +"</a></td>"
                    +"<td>" + rs.getString(2) + "</td>"
                    +"<td>" + rs.getString(3) + "</td>"
                    +"<td>" + rs.getString(4) + "</td>"
                    +"<td>" + rs.getString(5) + "</td>"
                    +"<td>" + rs.getString(6) + "</td>"
                    +"<td><a href=pinjamServlet?aksi=Delete&no_transaksi" + rs.getString(1) + ">hapus</a></td>"
                    +"</tr>");
        }
    %>
</table>