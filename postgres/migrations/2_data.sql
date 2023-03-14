INSERT INTO public.top3 (created_at) VALUES(CURRENT_TIMESTAMP);

INSERT INTO public.todo (id, title, complete, top3_id) VALUES(1, 'Research tech', false, 1);
INSERT INTO public.todo (id, title, complete, top3_id) VALUES(2, 'Write article', false, 1);
INSERT INTO public.todo (id, title, complete, top3_id) VALUES(3, 'Publish article', false, 1);
