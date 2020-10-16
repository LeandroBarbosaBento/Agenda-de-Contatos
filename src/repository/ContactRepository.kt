package repository

import entity.ContactEntity

//Classe responsável por armazenar os dados
class ContactRepository {

    /* Companion object garante que os dados permanecerão os mesmos
     * mesmo que a classe seja instanciada mais de uma vez
     */
    companion object {
        private val contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: ContactEntity) {

            //Percorrer a lista para encontrar o index
            var index = 0
            for (item in contactList.withIndex()) {
                if (item.value.name == contact.name && item.value.phone == contact.phone) {
                    index = item.index
                    break
                }

            }
            contactList.removeAt(index)
        }

        fun getList() : List<ContactEntity>{
            return contactList
        }
    }

}