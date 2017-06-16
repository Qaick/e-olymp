package my.backups;

/**
 * Created by olehb on 13.12.16.
 */
public class TestTimeFucker {
    public static void main(String[] args) {
        System.out.println(0+'0');
        long time = System.nanoTime();
        toCharArray();
        System.out.println("time: " + (System.nanoTime()-time));
        time = System.nanoTime();
        charAt();
        System.out.println("time: " + (System.nanoTime()-time));
    }

    public static void toCharArray() {
        char[] carr = s.toCharArray();
        long summ = 0;
        for (int i = 0; i < s.length(); i++) {
            summ+=carr[i];
        }
    }

    public static void charAt() {
        long summ = 0;
        for (int i = 0; i < s.length(); i++) {
            summ+=s.charAt(i);
        }
    }


    public static final String s = "Book manufacture in modern times\n" +
            "Main article: Bookbinding\n" +
            "See also: Publishing\n" +
            "\n" +
            "The spine of the book is an important aspect in book design, especially in the cover design. When the books are stacked up or stored in a shelf, the details on the spine is the only visible surface that contains the information about the book. In stores, it is the details on the spine that attract buyers' attention first.\n" +
            "The methods used for the printing and binding of books continued fundamentally unchanged from the 15th century into the early 20th century. While there was more mechanization, a book printer in 1900 had much in common with Gutenberg.\n" +
            "\n" +
            "Gutenberg's invention was the use of movable metal types, assembled into words, lines, and pages and then printed by letterpress to create multiple copies.\n" +
            "\n" +
            "Modern paper books are printed on papers designed specifically for printed books. Traditionally, book papers are off-white or low-white papers (easier to read), are opaque to minimise the show-through of text from one side of the page to the other and are (usually) made to tighter caliper or thickness specifications, particularly for case-bound books. Different paper qualities are used depending on the type of book: Machine finished coated papers, woodfree uncoated papers, coated fine papers and special fine papers are common paper grades.\n" +
            "\n" +
            "Today, the majority of books are printed by offset lithography.[citation needed] When a book is printed the pages are laid out on the plate so that after the printed sheet is folded the pages will be in the correct sequence. Books tend to be manufactured nowadays in a few standard sizes. The sizes of books are usually specified as \"trim size\": the size of the page after the sheet has been folded and trimmed. The standard sizes result from sheet sizes (therefore machine sizes) which became popular 200 or 300 years ago, and have come to dominate the industry. British conventions in this regard prevail throughout the English-speaking world, except for the USA. The European book manufacturing industry works to a completely different set of standards.\n" +
            "\n" +
            "Current processes\n" +
            "Layout\n" +
            "Modern bound books are organized according to a particular format called the book's layout. Although there is great variation in layout, modern books tend to adhere to as set of rules with regard to what the parts of the layout are and what their content usually includes. A basic layout will include a front cover, a back cover, and the book's content which is called its body copy or content pages. The front cover often bears the book's title (and subtitle, if any) and the name of its author or editor(s). The inside front cover page is usually left blank in both hardcover and paperback books. The next section, if present, is the book's front matter, which includes all textual material after the front cover but not part of the book's content— such things as a forward, a dedication, and a table of contents as well as publisher data such as the book's edition or printing number and place of publication. Between the body copy and the back cover goes the end matter which would include any indices, sets of tables, or diagrams, glossaries, or lists of cited works (though an edited book with multiple contributing authors usually places cited works at the end of each authored chapter). The inside back cover page, like that inside the front cover, is usually blank. The back cover itself is the usual place for the book's ISBN, and maybe a photograph of the author(s)/ editor(s), perhaps with a short introduction to them. Also here often appear plot summaries, barcodes, and excerpted reviews of the book.[25]\n" +
            "\n" +
            "Printing\n" +
            "\n" +
            "Book covers\n" +
            "Some books, particularly those with shorter runs (i.e. fewer copies) will be printed on sheet-fed offset presses, but most books are now printed on web presses, which are fed by a continuous roll of paper, and can consequently print more copies in a shorter time. As the production line circulates, a complete \"book\" is collected together in one stack, next to another, and another\n" +
            "\n" +
            "A web press carries out the folding itself, delivering bundles of signatures (sections) ready to go into the gathering line. Note that the pages of a book are printed two at a time, not as one complete book. Excess numbers are printed to make up for any spoilage due to make-readies or test pages to assure final print quality.\n" +
            "\n" +
            "A make-ready is the preparatory work carried out by the pressmen to get the printing press up to the required quality of impression. Included in make-ready is the time taken to mount the plate onto the machine, clean up any mess from the previous job, and get the press up to speed. As soon as the pressman decides that the printing is correct, all the make-ready sheets will be discarded, and the press will start making books. Similar make readies take place in the folding and binding areas, each involving spoilage of paper.\n" +
            "\n" +
            "Binding\n" +
            "After the signatures are folded and gathered, they move into the bindery. In the middle of last century there were still many trade binders – stand-alone binding companies which did no printing, specializing in binding alone. At that time, because of the dominance of letterpress printing, typesetting and printing took place in one location, and binding in a different factory. When type was all metal, a typical book's worth of type would be bulky, fragile and heavy. The less it was moved in this condition the better: so printing would be carried out in the same location as the typesetting. Printed sheets on the other hand could easily be moved. Now, because of increasing computerization of preparing a book for the printer, the typesetting part of the job has flowed upstream, where it is done either by separately contracting companies working for the publisher, by the publishers themselves, or even by the authors. Mergers in the book manufacturing industry mean that it is now unusual to find a bindery which is not also involved in book printing (and vice versa).\n" +
            "\n" +
            "If the book is a hardback its path through the bindery will involve more points of activity than if it is a paperback.\n" +
            "\n" +
            "Unsewn binding, is now increasingly common. The signatures of a book can also be held together by \"Smyth sewing\" using needles, \"McCain sewing\", using drilled holes often used in schoolbook binding, or \"notch binding\", where gashes about an inch long are made at intervals through the fold in the spine of each signature. The rest of the binding process is similar in all instances. Sewn and notch bound books can be bound as either hardbacks or paperbacks.\n" +
            "\n" +
            "Finishing\n" +
            "\n" +
            "Book pages\n" +
            "\"Making cases\" happens off-line and prior to the book's arrival at the binding line. In the most basic case-making, two pieces of cardboard are placed onto a glued piece of cloth with a space between them into which is glued a thinner board cut to the width of the spine of the book. The overlapping edges of the cloth (about 5/8\" all round) are folded over the boards, and pressed down to adhere. After case-making the stack of cases will go to the foil stamping area for adding decorations and type.\n" +
            "\n" +
            "Digital printing\n" +
            "Recent developments in book manufacturing include the development of digital printing. Book pages are printed, in much the same way as an office copier works, using toner rather than ink. Each book is printed in one pass, not as separate signatures. Digital printing has permitted the manufacture of much smaller quantities than offset, in part because of the absence of make readies and of spoilage. One might think of a web press as printing quantities over 2000, quantities from 250 to 2000 being printed on sheet-fed presses, and digital presses doing quantities below 250. These numbers are of course only approximate and will vary from supplier to supplier, and from book to book depending on its characteristics. Digital printing has opened up the possibility of print-on-demand, where no books are printed until after an order is received from a customer.\n" +
            "\n" +
            "E-book\n" +
            "Main article: e-book\n" +
            "The term e-book is a contraction of \"electronic book\"; it refers to a book-length publication in digital form.[26] An e-book is usually made available through the internet, but also on CD-ROM and other forms. E-Books may be read either via a computer or by means of a portable book display device known as an e-book reader, such as the Sony Reader, Barnes & Noble Nook, Kobo eReader, or the Amazon Kindle. These devices attempt to mimic the experience of reading a print book.\n" +
            "\n" +
            "Information explosion\n" +
            "Throughout the 20th century, libraries have faced an ever-increasing rate of publishing, sometimes called an information explosion. The advent of electronic publishing and the internet means that much new information is not printed in paper books, but is made available online through a digital library, on CD-ROM, or in the form of e-books. An on-line book is an e-book that is available online through the internet.\n" +
            "\n" +
            "Though many books are produced digitally, most digital versions are not available to the public, and there is no decline in the rate of paper publishing.[27] There is an effort, however, to convert books that are in the public domain into a digital medium for unlimited redistribution and infinite availability. This effort is spearheaded by Project Gutenberg combined with Distributed Proofreaders.\n" +
            "\n" +
            "There have also been new developments in the process of publishing books. Technologies such as POD or \"print on demand\", which make it possible to print as few as one book at a time, have made self-publishing much easier and more affordable. On-demand publishing has allowed publishers, by avoiding the high costs of warehousing, to keep low-selling books in print rather than declaring them out of print.\n" +
            "\n" +
            "Book design\n" +
            "Main article: Book design\n" +
            "Book design is the art of incorporating the content, style, format, design, and sequence of the various components of a book into a coherent whole.\n" +
            "\n" +
            "In the words of Jan Tschichold, book design \"though largely forgotten today, methods and rules upon which it is impossible to improve have been developed over centuries. To produce perfect books these rules have to be brought back to life and applied.\" Richard Hendel describes book design as \"an arcane subject\" and refers to the need for a context to understand what that means.\n" +
            "\n" +
            "Sizes\n" +
            "Main article: Book size\n" +
            "\n" +
            "Real-size facsimile of Codex Gigas\n" +
            "\n" +
            "The world's largest book\n" +
            "The size of a modern book is based on the printing area of a common flatbed press. The pages of type were arranged and clamped in a frame, so that when printed on a sheet of paper the full size of the press, the pages would be right side up and in order when the sheet was folded, and the folded edges trimmed.\n" +
            "\n" +
            "The most common book sizes are:\n" +
            "\n" +
            "Quarto (4to): the sheet of paper is folded twice, forming four leaves (eight pages) approximately 11-13 inches (ca 30 cm) tall\n" +
            "Octavo (8vo): the most common size for current hardcover books. The sheet is folded three times into eight leaves (16 pages) up to 9 ¾\" (ca 23 cm) tall.\n" +
            "DuoDecimo (12mo): a size between 8vo and 16mo, up to 7 ¾\" (ca 18 cm) tall\n" +
            "Sextodecimo (16mo): the sheet is folded four times, forming 16 leaves (32 pages) up to 6 ¾\" (ca 15 cm) tall\n" +
            "Sizes smaller than 16mo are:\n" +
            "\n" +
            "24mo: up to 5 ¾\" (ca 13 cm) tall.\n" +
            "32mo: up to 5\" (ca 12 cm) tall.\n" +
            "48mo: up to 4\" (ca 10 cm) tall.\n" +
            "64mo: up to 3\" (ca 8 cm) tall.\n" +
            "Small books can be called booklets.\n" +
            "\n" +
            "Sizes larger than quarto are:\n" +
            "\n" +
            "Folio: up to 15\" (ca 38 cm) tall.\n" +
            "Elephant Folio: up to 23\" (ca 58 cm) tall.\n" +
            "Atlas Folio: up to 25\" (ca 63 cm) tall.\n" +
            "Double Elephant Folio: up to 50\" (ca 127 cm) tall.\n" +
            "The largest extant medieval manuscript in the world is Codex Gigas 92 × 50 × 22 cm. The world's largest book is made of stone and is in Kuthodaw Pagoda (Burma).\n" +
            "\n" +
            "The longest book title in the world is 670 words long[citation needed].\n" +
            "\n" +
            "Types\n" +
            "By content\n" +
            "\n" +
            "Novels in a bookstore\n" +
            "A common separation by content are fiction and non-fiction books. This simple separation can be found in most collections, libraries, and bookstores.\n" +
            "\n" +
            "Fiction\n" +
            "Many of the books published today are fiction, meaning that they are in-part or completely untrue. Historically, paper production was considered too expensive to be used for entertainment. An increase in global literacy and print technology led to the increased publication of books for the purpose of entertainment, and allegorical social commentary. Most fiction is additionally categorized by genre.\n" +
            "\n" +
            "The novel is the most common form of fiction book. Novels are stories that typically feature a plot, setting, themes and characters. Stories and narrative are not restricted to any topic; a novel can be whimsical, serious or controversial. The novel has had a tremendous impact on entertainment and publishing markets.[28] A novella is a term sometimes used for fiction prose typically between 17,500 and 40,000 words, and a novelette between 7,500 and 17,500. A Short story may be any length up to 10,000 words, but these word lengths vary.\n" +
            "\n" +
            "Comic books or graphic novels are books in which the story is illustrated. The characters and narrators use speech or thought bubbles to express verbal language.\n" +
            "\n" +
            "Non-fiction\n" +
            "\n" +
            "A page from a dictionary\n" +
            "In a library, a reference book is a general type of non-fiction book which provides information as opposed to telling a story, essay, commentary, or otherwise supporting a point of view. An almanac is a very general reference book, usually one-volume, with lists of data and information on many topics. An encyclopedia is a book or set of books designed to have more in-depth articles on many topics. A book listing words, their etymology, meanings, and other information is called a dictionary. A book which is a collection of maps is an atlas. A more specific reference book with tables or lists of data and information about a certain topic, often intended for professional use, is often called a handbook. Books which try to list references and abstracts in a certain broad area may be called an index, such as Engineering Index, or abstracts such as chemical abstracts and biological abstracts.\n" +
            "\n" +
            "\n" +
            "An atlas\n" +
            "Books with technical information on how to do something or how to use some equipment are called instruction manuals. Other popular how-to books include cookbooks and home improvement books.\n" +
            "\n" +
            "Students typically store and carry textbooks and schoolbooks for study purposes. Elementary school pupils often use workbooks, which are published with spaces or blanks to be filled by them for study or homework. In US higher education, it is common for a student to take an exam using a blue book.\n" +
            "\n" +
            "\n" +
            "A page from a notebook used as hand written diary\n" +
            "There is a large set of books that are made only to write private ideas, notes, and accounts. These books are rarely published and are typically destroyed or remain private. Notebooks are blank papers to be written in by the user. Students and writers commonly use them for taking notes. Scientists and other researchers use lab notebooks to record their notes. They often feature spiral coil bindings at the edge so that pages may easily be torn out.\n" +
            "\n" +
            "\n" +
            "A Telephone Directory, with business and residence listings.\n" +
            "Address books, phone books, and calendar/appointment books are commonly used on a daily basis for recording appointments, meetings and personal contact information.\n" +
            "\n" +
            "Books for recording periodic entries by the user, such as daily information about a journey, are called logbooks or simply logs. A similar book for writing the owner's daily private personal events, information, and ideas is called a diary or personal journal.\n" +
            "\n" +
            "Businesses use accounting books such as journals and ledgers to record financial data in a practice called bookkeeping.\n" +
            "\n" +
            "Other types\n" +
            "There are several other types of books which are not commonly found under this system. Albums are books for holding a group of items belonging to a particular theme, such as a set of photographs, card collections, and memorabilia. One common example is stamp albums, which are used by many hobbyists to protect and organize their collections of postage stamps. Such albums are often made using removable plastic pages held inside in a ringed binder or other similar smolder. Picture books are books for children with little text and pictures on every page.\n" +
            "\n" +
            "Hymnals are books with collections of musical hymns that can typically be found in churches. Prayerbooks or missals are books that contain written prayers and are commonly carried by monks, nuns, and other devoted followers or clergy.\n" +
            "\n" +
            "By physical format\n" +
            "\n" +
            "Hardcover books\n" +
            "\n" +
            "Paperback books\n" +
            "Hardcover books have a stiff binding. Paperback books have cheaper, flexible covers which tend to be less durable. An alternative to paperback is the glossy cover, otherwise known as a dust cover, found on magazines, and comic books. Spiral-bound books are bound by spirals made of metal or plastic. Examples of spiral-bound books include teachers' manuals and puzzle books (crosswords, sudoku).\n" +
            "\n" +
            "Publishing is a process for producing pre-printed books, magazines, and newspapers for the reader/user to buy.\n" +
            "\n" +
            "Publishers may produce low-cost, pre-publication copies known as galleys or 'bound proofs' for promotional purposes, such as generating reviews in advance of publication. Galleys are usually made as cheaply as possible, since they are not intended for sale.\n" +
            "\n" +
            "Libraries\n" +
            "Main article: Library\n" +
            "\n" +
            "Celsus Library was built in 135 AD and could house around 12,000 scrolls.\n" +
            "Private or personal libraries made up of non-fiction and fiction books, (as opposed to the state or institutional records kept in archives) first appeared in classical Greece. In ancient world the maintaining of a library was usually (but not exclusively) the privilege of a wealthy individual. These libraries could have been either private or public, i.e. for people who were interested in using them. The difference from a modern public library lies in the fact that they were usually not funded from public sources. It is estimated that in the city of Rome at the end of the 3rd century there were around 30 public libraries. Public libraries also existed in other cities of the ancient Mediterranean region (for example, Library of Alexandria).[29] Later, in the Middle Ages, monasteries and universities had also libraries that could be accessible to general public. Typically not the whole collection was available to public, the books could not be borrowed and often were chained to reading stands to prevent theft.\n" +
            "\n" +
            "The beginning of modern public library begins around 15th century when individuals started to donate books to towns.[30] The growth of a public library system in the United States started in the late 19th century and was much helped by donations from Andrew Carnegie. This reflected classes in a society: The poor or the middle class had to access most books through a public library or by other means while the rich could afford to have a private library built in their homes. In the United States the Boston Public Library 1852 Report of the Trustees established the justification for the public library as a tax-supported institution intended to extend educational opportunity and provide for general culture.[31]\n" +
            "\n" +
            "The advent of paperback books in the 20th century led to an explosion of popular publishing. Paperback books made owning books affordable for many people. Paperback books often included works from genres that had previously been published mostly in pulp magazines. As a result of the low cost of such books and the spread of bookstores filled with them (in addition to the creation of a smaller market of extremely cheap used paperbacks) owning a private library ceased to be a status symbol for the rich.\n" +
            "\n" +
            "In library and booksellers' catalogues, it is common to include an abbreviation such as \"Crown 8vo\" to indicate the paper size from which the book is made.\n" +
            "\n" +
            "When rows of books are lined on a book holder, bookends are sometimes needed to keep them from slanting.\n" +
            "\n" +
            "Identification and classification\n" +
            "During the 20th century, librarians were concerned about keeping track of the many books being added yearly to the Gutenberg Galaxy. Through a global society called the International Federation of Library Associations and Institutions (IFLA), they devised a series of tools including the International Standard Bibliographic Description (ISBD).\n" +
            "\n" +
            "\n" +
            "ISBN with barcode\n" +
            "Each book is specified by an International Standard Book Number, or ISBN, which is unique to every edition of every book produced by participating publishers, worldwide. It is managed by the ISBN Society. An ISBN has four parts: the first part is the country code, the second the publisher code, and the third the title code. The last part is a check digit, and can take values from 0–9 and X (10). The EAN Barcodes numbers for books are derived from the ISBN by prefixing 978, for Bookland, and calculating a new check digit.\n" +
            "\n" +
            "Commercial publishers in industrialized countries generally assign ISBNs to their books, so buyers may presume that the ISBN is part of a total international system, with no exceptions. However, many government publishers, in industrial as well as developing countries, do not participate fully in the ISBN system, and publish books which do not have ISBNs.\n" +
            "\n" +
            "A large or public collection requires a catalogue. Codes called \"call numbers\" relate the books to the catalogue, and determine their locations on the shelves. Call numbers are based on a Library classification system. The call number is placed on the spine of the book, normally a short distance before the bottom, and inside.\n" +
            "\n" +
            "Institutional or national standards, such as ANSI/NISO Z39.41 - 1997, establish the correct way to place information (such as the title, or the name of the author) on book spines, and on \"shelvable\" book-like objects, such as containers for DVDs, video tapes and software.\n" +
            "\n" +
            "\n" +
            "Books on library shelves with bookends, and call numbers visible on the spines\n" +
            "One of the earliest and most widely known systems of cataloguing books is the Dewey Decimal System. Another widely known system is the Library of Congress Classification system. Both systems are biased towards subjects which were well represented in US libraries when they were developed, and hence have problems handling new subjects, such as computing, or subjects relating to other cultures.[citation needed]\n" +
            "\n" +
            "Information about books and authors can be stored in databases like online general-interest book databases.\n" +
            "\n" +
            "Metadata about a book may include its ISBN or other classification number (see above), the names of contributors (author, editor, illustrator) and publisher, its date and size, and the language of the text.\n" +
            "\n" +
            "Classification systems\n" +
            "Bliss bibliographic classification (BC)\n" +
            "Chinese Library Classification (CLC)\n" +
            "Colon Classification\n" +
            "Dewey Decimal Classification (DDC)\n" +
            "Harvard-Yenching Classification\n" +
            "Library of Congress Classification (LCC)\n" +
            "New Classification Scheme for Chinese Libraries\n" +
            "Universal Decimal Classification (UDC)\n" +
            "Uses\n" +
            "Aside from the primary purpose of reading them, books are also used for other ends:\n" +
            "\n" +
            "A book can be an artistic artifact, a piece of art; this is sometimes known as an artists' book.\n" +
            "A book may be evaluated by a reader or professional writer to create a book review.\n" +
            "A book may be read by a group of people to use as a spark for social or academic discussion, as in a book club.\n" +
            "A book may be studied by students as the subject of a writing and analysis exercise in the form of a book report.\n" +
            "Books are sometimes used for their exterior appearance to decorate a room, such as a study.\n" +
            "Paper and conservation\n" +
            "Main article: Conservation and restoration of books, manuscripts, documents and ephemera\n" +
            "\n" +
            "Halfbound book with leather and marbled paper.\n" +
            "Paper was first made in China as early as 200 BC, and reached Europe through Muslim territories. At first made of rags, the industrial revolution changed paper-making practices, allowing for paper to be made out of wood pulp. Papermaking in Europe began in the 11th century, although vellum was also common there as page material up until the beginning of 16th century, vellum being the more expensive and durable option. Printers or publishers would often issue the same publication on both materials, to cater to more than one market.\n" +
            "\n" +
            "Paper made from wood pulp became popular in the early 20th century, because it was cheaper than linen or abaca cloth-based papers. Pulp-based paper made books less expensive to the general public. This paved the way for huge leaps in the rate of literacy in industrialised nations, and enabled the spread of information during the Second Industrial Revolution.\n" +
            "\n" +
            "Pulp paper, however, contains acid which eventually destroys the paper from within. Earlier techniques for making paper used limestone rollers, which neutralized the acid in the pulp. Books printed between 1850 and 1950 are primarily at risk; more recent books are often printed on acid-free or alkaline paper. Libraries today have to consider mass deacidification of their older collections in order to prevent decay.\n" +
            "\n" +
            "Stability of the climate is critical to the long-term preservation of paper and book material.[32] Good air circulation is important to keep fluctuation in climate stable. The HVAC system should be up to date and functioning efficiently. Light is detrimental to collections. Therefore, care should be given to the collections by implementing light control. General housekeeping issues can be addressed, including pest control. In addition to these helpful solutions, a library must also make an effort to be prepared if a disaster occurs, one that they cannot control. Time and effort should be given to create a concise and effective disaster plan to counteract any damage incurred through \"acts of God\" therefore an emergency management plan should be in place.";
}
