export class SecurityUtil {

  static getRole() {
    if (this.isEmpty()) {
      return -1;
    }
    return JSON.parse(localStorage.getItem('loggedUser')).role;
  }

  static clearLocalStorage() {
    localStorage.clear();
  }

  static isEmpty() {
    return localStorage.getItem('loggedUser') === null;
  }

  static getUsername() {
    return JSON.parse(localStorage.getItem('loggedUser')).username;
  }

  static getEmail() {
    return JSON.parse(localStorage.getItem('loggedUser')).email;
  }

  static getId() {
    if (this.isEmpty()) {
      return -1;
    }
    return JSON.parse(localStorage.getItem('loggedUser')).id;
  }

  static getUser() {
    return JSON.parse(localStorage.getItem('loggedUser'));
  }

}
