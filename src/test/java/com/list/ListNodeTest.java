package com.list;
import com.list.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class ListNodeTest {
    int[] rawData;

    @Nested
    class Initialization {
        @Test
        public void valShouldBeNullWhenNoParametersArePassed(){
            var node = new ListNode();
            assertEquals(0, node.val);
        }

        @Test
        public void nextShouldBeNullWhenNoParametersArePassed(){
            var node = new ListNode();
            assertEquals(null, node.next);
        }

        @Test
        public void valShouldBeOneWhenOneIsPassed(){
            var node = new ListNode(1);
            assertEquals(1, node.val);
        }

        @Test
        public void nextShouldBeNullWhenSecondParameterIsSkipped(){
            var node = new ListNode(1);
            assertEquals(null, node.next);
        }

        @Test
        public void valShouldBeOneWhenOneIsPassedAsFirstParameter(){
            var nextNode = new ListNode();
            var node = new ListNode(1,nextNode);
            assertEquals(1, node.val);
        }

        @Test
        public void nextNodeShouldBeLinkedWhenANodeIsPassedInSecondParameter(){
            var nextNode = new ListNode();
            var node = new ListNode(1,nextNode);
            assertEquals(nextNode, node.getNext());
        }
    }

    @Nested
    class WhenConstructLinkedListIsCalled{
        ListNode head;

        @Test
        public void headShouldBeNullWhenInputArrayIsEmpty(){ rawData = new int[] {}; }

        @Nested
        class AndWhenFourItemsOfRawDataIsPassed {
            @BeforeEach
            public void setUp(){
                rawData = new int[] { 1, 2, 3, 4 };
                head = new ListNode(rawData[0]);
                head.constructLinkedList(rawData, head, 0);
            }

            @Test
            public void headShouldBeOneWhen(){ assertEquals(1, head.val); }

            @Test
            public void secondItemShouldBeTwo(){ assertEquals(2, head.next.val); }

            @Test
            public void thirdItemShouldBeThree(){ assertEquals(3, head.next.next.val); }

            @Test
            public void fourthItemShouldBeFour(){ assertEquals(4, head.next.next.next.val); }

            @Test
            public void fifthItemShouldNotBeReachable(){ assertEquals(null, head.next.next.next.next); }

            @Nested
            class AndWhenPrintLinkedListIsCalled {
                @Test
                public void itShouldPrintAllFourItems(){
                    assertEquals("1 -> 2 -> 3 -> 4", ListNode.printLinkedList(head));
                }
            }
        }

        @Nested
        class AndRawDataContainingOneItemIsPassed {
            @BeforeEach
            public void setUp(){
                rawData = new int[] { 4 };
                head = new ListNode(rawData[0]);
                head.constructLinkedList(rawData, head, 0);
            }

            @Test
            public void headShouldBeFour() { assertEquals(4, head.getVal()); }

            @Test
            public void headShouldPointToNull() { assertEquals(null, head.getNext()); }

            @Nested
            class AndWhenPrintLinkedListIsCalled {
                @Test
                public void itShouldPrintOnlyOneItem() { assertEquals("4", ListNode.printLinkedList(head)); }
            }
        }
    }
}