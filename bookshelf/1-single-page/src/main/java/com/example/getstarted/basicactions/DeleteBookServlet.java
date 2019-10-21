/* Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.getstarted.basicactions;

import com.example.getstarted.daos.BookDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// [START bookshelf_delete_servlet]
@SuppressWarnings("serial")
@WebServlet(
    name = "delete",
    urlPatterns = {"/delete"})
public class DeleteBookServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    String id = req.getParameter("id");
    BookDao dao = (BookDao) this.getServletContext().getAttribute("dao");
    try {
      dao.deleteBook(id);
      resp.sendRedirect("/books");
    } catch (Exception e) {
      throw new ServletException("Error deleting book", e);
    }
  }
}
// [END bookshelf_delete_servlet]